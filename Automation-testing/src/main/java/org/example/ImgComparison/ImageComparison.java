package org.example.ImgComparison;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ImageComparison {

    public static void compareTwoImg() throws IOException {

        BufferedImage expected = ImageIO.read(new FileInputStream("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                "Automation-testing\\src\\main\\java\\org\\example\\ImgComparison\\img_2.png"));

        BufferedImage actual = ImageIO.read(new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice\\" +
                "Automation-testing\\src\\main\\java\\org\\example\\ImgComparison\\img_1.png"));

        ImageDiff diff = new ImageDiffer().makeDiff(expected, actual);

        double n = Math.random();

        if (diff.hasDiff()) {

//            ImageIO.write(diff.getMarkedImage(), "PNG", new File("C:\\Users\\aximsoft\\IdeaProjects\\qa-automation-practice" +
//                    "\\Automation-testing\\src\\main\\java\\org\\example\\ImgComparison\\diff "+n+".png"));

            System.out.println("Images are NOT the same");
        } else {
            System.out.println("Images are the same");
        }
    }


    public static void main(String[] args) throws IOException {
        compareTwoImg();
    }
}
