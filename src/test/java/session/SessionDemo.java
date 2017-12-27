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
package session;

import com.jfinal.aop.Before;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import io.jboot.Jboot;
import io.jboot.web.controller.JbootController;
import io.jboot.web.controller.annotation.RequestMapping;
import service.User;


@RequestMapping("/session")
public class SessionDemo extends JbootController {


    public static void main(String[] args) {

        Jboot.run(args);
    }


    public void index() {

        User user = new User();
        user.setId(100);
        user.setName("Micahel Yang");

        setSessionAttr("user", user);
        renderHtml("session已经成功设置数据，请访问<a href=\"/session/show\">这里</a>查看session数据");
    }

    @Before(SessionInViewInterceptor.class)
    public void show() {
        render("/htmls/session/session.html");
    }


}
