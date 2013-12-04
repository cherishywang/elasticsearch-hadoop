/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.elasticsearch.hadoop.util;

import java.util.List;

import org.elasticsearch.hadoop.cfg.Settings;

public abstract class NodeUtils {

    public static List<String> qualifyHosts(String hosts, int defaultPort) {
        List<String> list = StringUtils.tokenize(hosts);
        for (int i = 0; i < list.size(); i++) {
            String host = list.get(i);
            list.set(i, qualifyHost(host, defaultPort));
        }
        return list;
    }

    public static String qualifyHost(String host, int defaultPort) {
        return (host.contains(":") ? host : host + ":" + defaultPort);
    }

    public static List<String> nodes(Settings settings) {
        return qualifyHosts(settings.getNodes(), settings.getPort());
    }
}
