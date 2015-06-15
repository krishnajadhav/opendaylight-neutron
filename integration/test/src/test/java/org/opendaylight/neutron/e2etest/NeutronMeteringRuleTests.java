/*
 * Copyright (C) 2015 IBM, Inc.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.neutron.e2etest;

import java.io.OutputStreamWriter;

import java.lang.Thread;

import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Assert;

public class NeutronMeteringRuleTests {
    String base;

    public NeutronMeteringRuleTests(String base) {
        this.base = base;
    }

    public void meteringRule_collection_get_test() {
        String url_s = base + "/metering/metering-label-rules";
        try {
            URL url = new URL(url_s);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
            Assert.assertEquals("Metering Rule Collection GET failed",
                        200, httpConn.getResponseCode());
        } catch (Exception e) {
            Assert.assertFalse("E2E Tests Failed", true);
        }
    }

    //TODO handle SB check
    public void singleton_meteringLabel_create_test() {
        String url_s = base + "/metering/metering-label-rules";
        String content = "{ \"metering_label_rule\": { " +
            "\"remote_ip_prefix\": \"10.0.1.0/24\", " +
            "\"direction\": \"ingress\", " +
            "\"metering_label_id\": \"bc91b832-8465-40a7-a5d8-ba87de442266\", " +
            "\"id\": \"00e13b58-b4f2-4579-9c9c-7ac94615f9ae\", " +
            "\"excluded\": false } }";

        try {
            URL url = new URL(url_s);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("POST");
            httpConn.setRequestProperty("Content-Type", "application/json");
            httpConn.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
            httpConn.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(
                httpConn.getOutputStream());
            out.write(content);
            out.close();
            Assert.assertEquals("Singleton Metering Rule Post Failed NB",
                201, httpConn.getResponseCode());
        } catch (Exception e) {
            Assert.assertFalse("E2E Tests Failed", true);
        }
    }
}