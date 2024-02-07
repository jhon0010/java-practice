# Java 13


## Features

- **Yield Keyword in Switch-case Statement**: New syntax for switch expressions.
- **Text Blocks**: Introduced with triple quotes for multi-line string literals.
- **Reimplement the Legacy Socket API**:   Replaces the underlying implementation used by the java.net.Socket and 
- java.net.ServerSocket APIs with a simpler, more modern implementation. This change is aimed at improving the maintainability and debuggability of the code.
- **Dynamic CDS Archives**:  The Class Data Sharing (CDS) feature has been enhanced to allow the dynamic archiving of classes at the end of the JVM lifecycle. This feature is enabled by default and can be disabled with the -XX:-UseDynamicArchive option.
- **ZGC: Uncommit Unused Memory**:  The Z Garbage Collector (ZGC) has been enhanced to uncommit memory that is no longer used by the heap. This feature is enabled by default and can be disabled with the -XX:-ZUncommit option.
