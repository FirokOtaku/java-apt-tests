package firok.test.apt;

import firok.test.aclass.AnnotationClass;
import firok.test.aruntime.AnnotationRuntime;
import firok.test.asource.AnnotationSource;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_21)
@SupportedAnnotationTypes({
        "firok.test.aruntime.AnnotationRuntime",
        "firok.test.aclass.AnnotationClass",
        "firok.test.asource.AnnotationSource",
})
public class MainProcessor extends AbstractProcessor
{
    private Messager messager;
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv)
    {
        super.init(processingEnv);
        this.messager = processingEnv.getMessager();
        messager.printNote("APT 初始化完成");
    }

    private void print(String type, Set<? extends Element> set)
    {
        var msg = new StringBuilder();
        msg.append(type).append(" 注解数量: ").append(set.size()).append("\n");

        for(var ele : set)
        {
            msg.append(" * ").append(ele).append("\n");
        }

        messager.printNote(msg.toString());
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment re)
    {
        messager.printNote("APT 开始处理");
        var setEleRuntime = re.getElementsAnnotatedWith(AnnotationRuntime.class);
        var setEleClass = re.getElementsAnnotatedWith(AnnotationClass.class);
        var setEleSource = re.getElementsAnnotatedWith(AnnotationSource.class);

        print("runtime", setEleRuntime);
        print("class", setEleClass);
        print("source", setEleSource);

        return true;
    }
}
