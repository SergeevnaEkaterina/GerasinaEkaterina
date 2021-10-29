package com.epam.tc.util;

import io.qameta.allure.Attachment;

public class AttachmentUtils {

    @Attachment(type = "image/png")
    public static byte[] attach(final String name, final byte[] source) {
        return source;
    }
}
