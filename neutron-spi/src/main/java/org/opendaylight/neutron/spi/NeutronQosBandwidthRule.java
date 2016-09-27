/*
 * Copyright (c) 2016 Intel Corporation.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.spi;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public final class NeutronQosBandwidthRule extends NeutronObject<NeutronQosBandwidthRule>
        implements Serializable, INeutronObject<NeutronQosBandwidthRule> {
    private static final long serialVersionUID = 1L;

    @XmlElement(name = "max_kbps")
    BigInteger maxKbps;

    @XmlElement(name = "max_burst_kbps")
    BigInteger maxBurstKbps;

    public BigInteger getMaxKbps() {
        return maxKbps;
    }

    public void setMaxKbps(BigInteger maxKbps) {
        this.maxKbps = maxKbps;
    }

    public BigInteger getMaxBurstKbps() {
        return maxBurstKbps;
    }

    public void setMaxBurstKbps(BigInteger maxBurstKbps) {
        this.maxBurstKbps = maxBurstKbps;
    }

    public NeutronQosBandwidthRule extractFields(List<String> fields) {
        NeutronQosBandwidthRule ans = new NeutronQosBandwidthRule();
        for (String s : fields) {
            extractField(s, ans);
            if (s.equals("max_kbps")) {
                ans.setMaxKbps(this.getMaxKbps());
            }
            if (s.equals("max_burst_kbps")) {
                ans.setMaxBurstKbps(this.getMaxBurstKbps());
            }
        }
        return ans;
    }

    @Override
    public String toString() {
        return "qosBandwidthRules{" + "qosBandwidthRuleUUID='" + uuid + '\'' + ", qosBandwidthRuleTenantID='" + tenantID
                + '\'' + ", qosBandwidthMaxValue='" + maxKbps + '\'' + ", qosBandwidthMaxBurst='" + maxBurstKbps + '\''
                + '}';
    }
}
