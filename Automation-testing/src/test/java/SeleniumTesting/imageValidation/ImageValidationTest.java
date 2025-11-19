package SeleniumTesting.imageValidation;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageValidationTest {

    @Test(dataProvider = "diff_images")
    public void compareTwoImage(String actualImagePath,String expectedImagePath) throws IOException {

        boolean isSame = false;

        BufferedImage actualImage = ImageIO.read(new FileInputStream(actualImagePath));
        BufferedImage expectedImage = ImageIO.read(new FileInputStream(expectedImagePath));

        ImageDiff diff =new ImageDiffer().makeDiff(expectedImage,actualImage);

        if(diff.hasDiff()){
            isSame = true;
        }

        Assert.assertEquals(isSame,true);
    }

    @DataProvider(name = "diff_images")
    public Object[][] differentImages(){
        Object[][] data = {
                {
                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                            "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\black.png",

                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                            "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\blur_img.png"

                },
                {
                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                            "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\img.png",

                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                            "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\img_1.png"
                }
        };

        return data;
    }

    @DataProvider(name = "same_images")
    public Object[][] sameImages(){
        Object[][] data = {
                {"C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                        "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\black.png",

                "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing" +
                        "\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\black.png"},
                {
                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                            "Automation-testing\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\blur_img.png",

                    "C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\Automation-testing" +
                            "\\src\\test\\java\\SeleniumTesting\\imageValidation\\images\\blur_img.png"
                }
        };
        return data;
    }

}
