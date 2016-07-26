package link.arata.common.enums;

import java.util.Objects;

/**
 * 改行のタイプのEnum
 * 
 * @author arata
 *
 */
public enum LineBreakType {
    CR("\r"), LF("\n"), CRLF("\r\n"), NONE("");

    private String physicalString;

    /**
     * 改行コードの実際の文字列を取得する
     * 
     * @return 改行コードの実際の文字列
     */
    public String getPhysicalString() {
        return physicalString;
    }

    private LineBreakType(String physicalString) {
        this.physicalString = Objects.requireNonNull(physicalString);
    }
}
