package application.enums;

import lombok.Getter;

@Getter
public enum FileFormatEnum {
    TXT("txt"),
    PDF("pdf"),
    DOC("doc"),
    DOCX("docx"),
    XLSX("xlsx"),
    CSV("csv"),
    JPEG("jpeg"),
    PNG("png"),
    GIF("gif"),
    HTML("html"),
    XML("xml"),
    JSON("json"),
    ZIP("zip"),
    RAR("rar"),
    MP4("mp4"),
    MP3("mp3"),
    WAV("wav"),
    TXT_UTF8("txt"); // You can include specific variations like UTF-8

    private final String format;

    FileFormatEnum(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return this.format;
    }
}
