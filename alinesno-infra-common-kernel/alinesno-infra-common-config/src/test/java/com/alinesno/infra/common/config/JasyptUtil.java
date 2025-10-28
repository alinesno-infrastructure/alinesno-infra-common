package com.alinesno.infra.common.config;

import org.jasypt.util.text.BasicTextEncryptor;
import java.util.Scanner;

/**
 * JasyptUtil 加密工具类 - 交互式版本
 */
public class JasyptUtil {

    private static BasicTextEncryptor encryptor;

    static {
        // 初始化加密器
        String key = System.getenv("JASYPT_SECRET_KEY");
        if (key == null || key.trim().isEmpty()) {
            System.err.println("警告: 未找到环境变量 JASYPT_SECRET_KEY，使用默认密钥");
            key = "default-secret-key-2024";
        }

        encryptor = new BasicTextEncryptor();
        encryptor.setPassword(key);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Jasypt 加密解密工具 ===");
        System.out.println("使用说明:");
        System.out.println("1. 输入 'e:要加密的文本' 进行加密");
        System.out.println("2. 输入 'd:要解密的文本' 进行解密");
        System.out.println("3. 输入 'q' 或 'quit' 退出程序");
        System.out.println("4. 输入 'h' 或 'help' 显示帮助");
        System.out.println("==========================");

        while (true) {
            System.out.print("\n请输入操作和文本: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                continue;
            }

            // 退出命令
            if (input.equalsIgnoreCase("q") || input.equalsIgnoreCase("quit")) {
                System.out.println("程序已退出");
                break;
            }

            // 帮助命令
            if (input.equalsIgnoreCase("h") || input.equalsIgnoreCase("help")) {
                showHelp();
                continue;
            }

            // 处理加密解密命令
            processCommand(input);
        }

        scanner.close();
    }

    /**
     * 处理用户输入的命令
     */
    private static void processCommand(String input) {
        try {
            if (input.startsWith("e:")) {
                // 加密操作
                String textToEncrypt = input.substring(2).trim();
                if (textToEncrypt.isEmpty()) {
                    System.out.println("错误: 加密文本不能为空");
                    return;
                }
                String encrypted = encryptor.encrypt(textToEncrypt);
                System.out.println("加密结果: " + encrypted);

                // 自动解密验证
                String decrypted = encryptor.decrypt(encrypted);
                System.out.println("解密验证: " + decrypted);

            } else if (input.startsWith("d:")) {
                // 解密操作
                String textToDecrypt = input.substring(2).trim();
                if (textToDecrypt.isEmpty()) {
                    System.out.println("错误: 解密文本不能为空");
                    return;
                }
                String decrypted = encryptor.decrypt(textToDecrypt);
                System.out.println("解密结果: " + decrypted);

            } else {
                System.out.println("错误: 未知命令格式，请输入 'e:文本' 或 'd:文本'");
                System.out.println("输入 'h' 查看帮助");
            }
        } catch (Exception e) {
            System.out.println("操作失败: " + e.getMessage());
            System.out.println("请检查输入格式和密钥是否正确");
        }
    }

    /**
     * 显示帮助信息
     */
    private static void showHelp() {
        System.out.println("\n=== 帮助信息 ===");
        System.out.println("加密示例: e:hello world");
        System.out.println("  结果: 加密结果: XyZ123AbC...");
        System.out.println("        解密验证: hello world");
        System.out.println("解密示例: d:XyZ123AbC...");
        System.out.println("  结果: 解密结果: hello world");
        System.out.println("退出: q 或 quit");
        System.out.println("帮助: h 或 help");
        System.out.println("===============");
    }

    /**
     * 加密方法（供其他类调用）
     */
    public static String encrypt(String text) {
        return encryptor.encrypt(text);
    }

    /**
     * 解密方法（供其他类调用）
     */
    public static String decrypt(String encryptedText) {
        return encryptor.decrypt(encryptedText);
    }
}