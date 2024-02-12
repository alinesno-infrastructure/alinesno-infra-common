package com.alinesno.infra.common.web.adapter.exception.file;

import lombok.Getter;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 上传异常类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Getter
public class FileUploadException extends Exception {

    private final Throwable cause;

    public FileUploadException() {
        this((String)null, (Throwable)null);
    }

    public FileUploadException(String msg) {
        this(msg, (Throwable)null);
    }

    public FileUploadException(String msg, Throwable cause) {
        super(msg);
        this.cause = cause;
    }

    public void printStackTrace(PrintStream stream) {
        super.printStackTrace(stream);
        if (this.cause != null) {
            stream.println("Caused by:");
            this.cause.printStackTrace(stream);
        }

    }

    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);
        if (this.cause != null) {
            writer.println("Caused by:");
            this.cause.printStackTrace(writer);
        }

    }

}
