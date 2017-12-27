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
package io.jboot.component.shiro.directives;

import com.jfinal.template.Env;
import com.jfinal.template.expr.ast.ExprList;
import com.jfinal.template.io.Writer;
import com.jfinal.template.stat.Scope;
import io.jboot.utils.ArrayUtils;
import io.jboot.web.directive.annotation.JFinalDirective;

/**
 * 有相应角色
 * #shiroHasRole(roleName)
 * body
 * #end
 */
@JFinalDirective("shiroHasRole")
public class ShiroHasRoleDirective extends JbootShiroDirectiveBase {

    @Override
    public void setExprList(ExprList exprList) {
        if (exprList.getExprArray().length != 1) {
            throw new IllegalArgumentException("#shiroHasRole must has one argument");
        }
        super.setExprList(exprList);
    }

    @Override
    public void onRender(Env env, Scope scope, Writer writer) {
        boolean hasRole = false;
        if (getSubject() != null && ArrayUtils.isNotEmpty(exprList.getExprArray()))
            if (getSubject().hasRole(exprList.getExprArray()[0].toString()))
                hasRole = true;

        if (hasRole)
            renderBody(env, scope, writer);
    }

    public boolean hasEnd() {
        return true;
    }

}
