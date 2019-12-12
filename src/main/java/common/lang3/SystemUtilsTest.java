package common.lang3;

import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import java.io.File;

/**
 * describe:
 *
 * @author syh
 * @date 2019/12/11
 */
public class SystemUtilsTest {

    @Test
    public void test() {
        String hostName = SystemUtils.getHostName();
        System.out.println(hostName);

        File javaHome = SystemUtils.getJavaHome();
        System.out.println(javaHome.getAbsolutePath());

        File javaIoTmpDir = SystemUtils.getJavaIoTmpDir();
        System.out.println(javaIoTmpDir.getAbsolutePath());

        File userHome = SystemUtils.getUserHome();
        System.out.println(userHome.getAbsolutePath());

        boolean javaVersionAtLeast = SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_11);
        System.out.println(javaVersionAtLeast);


    }

}
