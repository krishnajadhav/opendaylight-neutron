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

public class NeutronFloatingIPTests {
    String base;

    public NeutronFloatingIPTests(String base) {
        this.base = base;
    }

    public void floatingIP_collection_get_test() {
        String url = base + "/floatingips";
        ITNeutronE2E.test_fetch(url,"FloatingIP Collection GET failed");
    }

    public static void runTests(String base) {
        NeutronFloatingIPTests floatingIP_tester = new NeutronFloatingIPTests(base);
        floatingIP_tester.floatingIP_collection_get_test();
    }
}
