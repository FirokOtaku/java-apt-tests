module firok.test.pcb
{
    requires firok.test.aclass;
    requires firok.test.pca;
    requires firok.test.apt;

    exports firok.test.pcb;

    uses firok.test.apt.MainProcessor;
}
