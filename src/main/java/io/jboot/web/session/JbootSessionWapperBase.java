/**
 * Copyright (c) 2015-2017, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jboot.web.session;

import io.jboot.utils.StringUtils;
import io.jboot.web.JbootRequestContext;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public abstract class JbootSessionWapperBase implements HttpSession {

    private static final long SESSION_TIME = TimeUnit.DAYS.toSeconds(2);


    @Override
    public long getCreationTime() {
        return 0;
    }

    @Override
    public String getId() {
        return getOrCreatSessionId();
    }

    @Override
    public long getLastAccessedTime() {
        return 0;
    }

    @Override
    public ServletContext getServletContext() {
        return null;
    }

    @Override
    public void setMaxInactiveInterval(int interval) {

    }

    @Override
    public int getMaxInactiveInterval() {
        return 0;
    }

    @Override
    public HttpSessionContext getSessionContext() {
        throw new RuntimeException("getSessionContext method not finished.");
    }

    @Override
    public void putValue(String name, Object value) {
        setAttribute(name, value);
    }

    @Override
    public Object getValue(String name) {
        return getAttribute(name);
    }

    @Override
    public void removeValue(String name) {
        removeAttribute(name);
    }

    @Override
    public void invalidate() {

    }

    @Override
    public boolean isNew() {
        return false;
    }


    protected String getOrCreatSessionId() {
        String sessionid = getCookie("JSESSIONID");
        if (StringUtils.isNotBlank(sessionid)) {
            return sessionid;
        }

        sessionid = JbootRequestContext.getRequestAttr("JSESSIONID");
        if (StringUtils.isNotBlank(sessionid)) {
            return sessionid;
        }

        sessionid = UUID.randomUUID().toString().replace("-", "");
        JbootRequestContext.setRequestAttr("JSESSIONID", sessionid);
        setCookie("JSESSIONID", sessionid, (int) SESSION_TIME);
        return sessionid;
    }


    /**
     * Get cookie value by cookie name.
     */
    private String getCookie(String name) {
        Cookie cookie = getCookieObject(name);
        return cookie != null ? cookie.getValue() : null;
    }

    /**
     * Get cookie object by cookie name.
     */
    private Cookie getCookieObject(String name) {
        Cookie[] cookies = JbootRequestContext.getRequest().getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals(name))
                    return cookie;
        return null;
    }

    /**
     * @param name
     * @param value
     * @param maxAgeInSeconds
     */
    private void setCookie(String name, String value, int maxAgeInSeconds) {
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(maxAgeInSeconds);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        JbootRequestContext.getResponse().addCookie(cookie);
    }

}
