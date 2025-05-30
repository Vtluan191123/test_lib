package com.vtluan.demo.lib.consts;

public enum VariableEvn {
        VTLUAN("Văn Thế Luân"),
        AAA("Một giá trị nào đó");

        private final String value;

        VariableEvn(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}
