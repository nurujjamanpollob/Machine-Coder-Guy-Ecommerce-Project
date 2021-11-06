/*
 * Copyright (c) 2021 Nurujjaman Pollob, All Right Reserved.
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *           http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.nurujjamanpollob.machinecoderguystore.backend.utility;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Nurujjaman Pollob
 * <p>
 * Utility class designed to extract IP address from HTTP request
 * @see HttpServletRequest#getRemoteAddr() for more information
 */

@SuppressWarnings({"unused"})
public class RequestUtil {


    /**
     * IP header names
     */
    private static final String[] IP_HEADER_NAMES = {
            "X-Forwarded-For",
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP",
            "HTTP_X_FORWARDED_FOR",
            "HTTP_X_FORWARDED",
            "HTTP_X_CLUSTER_CLIENT_IP",
            "HTTP_CLIENT_IP",
            "HTTP_FORWARDED_FOR",
            "HTTP_FORWARDED",
            "HTTP_VIA",
            "REMOTE_ADDR"
    };

    /**
     * @param requestAttributes pass request attribute parameter from HTTP request
     * @return IP address of client, if attribute is null it is simply returns 0.0.0.0
     * You can call this method with this parameter: RequestContextHolder.currentRequestAttributes()
     * @see RequestContextHolder#currentRequestAttributes() for more information, Also
     * @see HttpServletRequest for more information.
     */
    public static String getRemoteIP(RequestAttributes requestAttributes) {
        // if the requestAttributes is null
        if (requestAttributes == null) {
            return "0.0.0.0";
        }

        // get HttpServletRequest object from RequestAttributes
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        // create a simple stream of IP Headers
        String ip = Arrays.stream(IP_HEADER_NAMES)
                // get single IP header name from IP_HEADER_NAMES
                .map(request::getHeader)
                // filter by if single header is not null and this header is must not unknown by ignoring case
                .filter(h -> h != null && h.length() != 0 && !"unknown".equalsIgnoreCase(h))
                // we will then split ip address by (,) and get first address from this map
                .map(h -> h.split(",")[0])

                // add this to ip address String, like ip + ":" + split[0] from current get header value
                .reduce("", (h1, h2) -> h1 + ":" + h2);

        return ip + request.getRemoteAddr();
    }


}
