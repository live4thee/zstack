package org.zstack.sdk;

import org.zstack.sdk.PciDeviceInventory;

public class DetachPciDeviceFromVmResult {
    public PciDeviceInventory inventory;
    public void setInventory(PciDeviceInventory inventory) {
        this.inventory = inventory;
    }
    public PciDeviceInventory getInventory() {
        return this.inventory;
    }

}
