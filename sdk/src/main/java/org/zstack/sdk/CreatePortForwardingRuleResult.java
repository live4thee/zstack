package org.zstack.sdk;

import org.zstack.sdk.PortForwardingRuleInventory;

public class CreatePortForwardingRuleResult {
    public PortForwardingRuleInventory inventory;
    public void setInventory(PortForwardingRuleInventory inventory) {
        this.inventory = inventory;
    }
    public PortForwardingRuleInventory getInventory() {
        return this.inventory;
    }

}
