package org.employeems.util;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtil {
    /**
     * 加密密码
     *
     * @param plainPassword 明文密码
     * @return 加密后的密码
     */
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    /**
     * 验证密码
     *
     * @param plainPassword 明文密码
     * @param hashedPassword 加密后的密码
     * @return 验证结果
     */
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
