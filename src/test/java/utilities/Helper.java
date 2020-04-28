package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Helper {
    static WebDriver driver = WebDriverFactory.getDriver();

    public static String takeScreenshot(String imgName) {
        String imgPath = imgName + "_" + getDateTime() + ".png";
        Path path = Paths.get("TestReport/screenshots", imgPath);
        try {
            Files.createDirectories(path.getParent());
            FileOutputStream fileOutputStream = new FileOutputStream(path.toString());
            fileOutputStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgPath;
    }

    private static String getDateTime() {
        return new SimpleDateFormat("yyMMdd-HHmmss").format(Calendar.getInstance().getTime());
    }
}
