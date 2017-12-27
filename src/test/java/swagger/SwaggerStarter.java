/**
 * Copyright (c) 2015-2017, Michael Yang 杨福海 (fuhai999@gmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 *  http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package swagger;

import io.jboot.Jboot;

/**
 * @author Michael Yang 杨福海 （fuhai999@gmail.com）
 * @version V1.0
 * @package config
 */
public class SwaggerStarter {


    /**
     * 启动后，访问：http://127.0.0.1:8080/swaggerui
     *
     * @param args
     */
    public static void main(String[] args) {


        //jboot端口号配置
        Jboot.setBootArg("jboot.server.port", "8080");

        Jboot.setBootArg("jboot.swagger.path", "/swaggerui");
        Jboot.setBootArg("jboot.swagger.title", "Jboot API 测试");
        Jboot.setBootArg("jboot.swagger.description", "这真的真的真的只是一个测试而已，不要当真。");
        Jboot.setBootArg("jboot.swagger.version", "1.0");
        Jboot.setBootArg("jboot.swagger.termsOfService", "http://jboot.io");
        Jboot.setBootArg("jboot.swagger.contactEmail", "fuhai999@gmail.com");
        Jboot.setBootArg("jboot.swagger.contactName", "fuhai999");
        Jboot.setBootArg("jboot.swagger.contactUrl", "http://jboot.io");
        Jboot.setBootArg("jboot.swagger.host", "127.0.0.1:8080");

        Jboot.run(args);


    }

}
