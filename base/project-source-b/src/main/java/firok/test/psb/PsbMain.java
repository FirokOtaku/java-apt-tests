package firok.test.psb;

import firok.test.asource.AnnotationSource;
import firok.test.psa.PsaMain;

@AnnotationSource
public class PsbMain
{
    static
    {
        System.out.println(PsaMain.class);

        System.out.println("psb main");
    }
}
