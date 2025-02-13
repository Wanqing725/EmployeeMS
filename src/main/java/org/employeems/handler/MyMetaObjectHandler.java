package org.employeems.handler;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.employeems.entity.core.Attendance;

import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, ResultHandler.class})
})
public class MyMetaObjectHandler implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement mappedStatement = (MappedStatement) args[0];
        Object parameter = args[1];

        // 自动填充 create_time 和 update_time
        if (parameter instanceof Attendance) {
            Attendance attendance = (Attendance) parameter;
            if (mappedStatement.getId().endsWith("insert")) {
                // 将 Date 转换为 LocalDateTime
                attendance.setCreateTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                attendance.setUpdateTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            } else if (mappedStatement.getId().endsWith("update")) {
                // 将 Date 转换为 LocalDateTime
                attendance.setUpdateTime(new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
            }
        }

        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
