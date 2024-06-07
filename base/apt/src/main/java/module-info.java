module firok.test.apt
{
    requires firok.test.aclass;
    requires firok.test.aruntime;
    requires firok.test.asource;
    requires java.compiler;

    exports firok.test.apt;

    provides javax.annotation.processing.Processor with firok.test.apt.MainProcessor;
}
