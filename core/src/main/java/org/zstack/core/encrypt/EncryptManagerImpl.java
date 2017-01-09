package org.zstack.core.encrypt;

import org.dom4j.io.STAXEventReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.zstack.core.Platform;
import org.zstack.core.cloudbus.CloudBus;
import org.zstack.core.db.DatabaseFacade;
import org.zstack.header.AbstractService;
import org.zstack.header.core.encrypt.APIUpdateEncryptKeyEvent;
import org.zstack.header.core.encrypt.APIUpdateEncryptKeyMsg;
import org.zstack.header.core.encrypt.ENCRYPT;
import org.zstack.header.core.encrypt.ENCRYPTParam;
import org.zstack.header.message.Message;
import org.zstack.header.volume.VolumeType;
import org.zstack.utils.Utils;
import org.zstack.utils.logging.CLogger;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Created by mingjian.deng on 16/12/28.
 */
public class EncryptManagerImpl extends AbstractService {
    private static final CLogger logger = Utils.getLogger(EncryptManagerImpl.class);
    @Autowired
    private CloudBus bus;

    @Autowired
    private DatabaseFacade dbf;

    @Override
    public boolean start() {
        return true;
    }

    @Override
    public boolean stop() {
        return true;
    }

    @Override
    public void handleMessage(Message msg) {
        if (msg instanceof APIUpdateEncryptKeyMsg) {
            handle((APIUpdateEncryptKeyMsg) msg);
        } else {
            bus.dealWithUnknownMessage(msg);
        }
    }

    private void handle(APIUpdateEncryptKeyMsg msg) {
        Set<Method> map = Platform.encryptedMethodsMap;
        logger.debug("decrypt passwords with old key and encrypt with new key");
        for (Method method: map) {
            String old_key = EncryptGlobalConfig.ENCRYPT_ALGORITHM.value();
            String new_key = msg.getEncryptKey();

            Class tempClass = method.getDeclaringClass();
            String className = tempClass.getSimpleName();
            //String paramName = method.getParameters()[0].getName();
            String paramName = "password";

            logger.debug(String.format("className is : %s",className));
            logger.debug(String.format("paramName is: %s ",paramName));


            //Class<?> classType = tempClass.

            //List<Object> tablelist = dbf.listAll(tempClass);
            /*Field field = method.getParameters();
            String old_value =*/
            EncryptRSA rsa = new EncryptRSA();

            String sql = "select uuid,"+paramName+" from "+className;
            logger.debug(String.format("sql is: %s ",sql));
            Query q = dbf.getEntityManager().createNativeQuery(sql);



            //String sql2 = "update "+className+" set "+paramName+" = "+ rsa.encrypt1()
            //q.setParameter("param", paramName);

            List aa = q.getResultList();

            for (int i=0; i<aa.size(); i++){
                logger.debug(String.format("result i is : %s, %s",((EncryptParam)aa.get(i)).getUuid(),((EncryptParam)aa.get(i)).getPassword())); ;
            }



            /*String sql = "update "+className+" set vol.vmInstanceUuid = null where vol.uuid in (:uuids)";
            Query q = dbf.getEntityManager().createQuery(sql);
            q.setParameter("uuids", dataVolumeUuids);
            q.executeUpdate();*/


            //String old_value = dbf.createQuery();

            APIUpdateEncryptKeyEvent evt = new APIUpdateEncryptKeyEvent();
            bus.publish(evt);
        }
    }

    @Override
    public String getId() {
        return bus.makeLocalServiceId(EncryptGlobalConfig.SERVICE_ID);
    }
}
