package com.epam.tc.hw4.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import java.io.InputStream;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AttachmentUtils {

    public void attachFromInputStream(final String name, final InputStream inputStream) {
        Allure.addAttachment(name, inputStream);
    }

    @Attachment
    public String makeStringAttachment(final List<String> stringsAttachment) {
        return stringsAttachment.toString();
    }

    @Attachment(type = "image/png", value = "Our attachment {name}")
    public byte[] makeScreenShotAttachment(final String name, final byte[] source) {
        return source;
    }
}
