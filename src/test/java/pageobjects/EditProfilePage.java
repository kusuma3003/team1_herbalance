package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProfilePage {

    public WebDriver driver;

    public EditProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // ---------------- LOCATORS for Edit Your Profile - UI ---------------------
    
    By pageTitle         = By.xpath("//h1[contains(text(),'Edit your Profile')]");
    By subTitle          = By.xpath("//*[contains(text(),'Update your personal information and preferences')]");

    By basicInfoTab      = By.xpath("//button[contains(text(),'Basic Information')]");
    By bodyMetricsTab    = By.xpath("//button[contains(text(),'Body Metrics')]");
    By prefHealthTab     = By.xpath("//button[contains(text(),'Preferences & Health')]");

    By activeTab         = By.xpath("//button[contains(@class,'active')]");

    By backButton        = By.xpath("//button[contains(text(),'Back')]");


    //  METHODS 
    
    public boolean isTitleVisible() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isSubtitleVisible() {
        return driver.findElement(subTitle).isDisplayed();
    }

    public int getTabCount() {
        return driver.findElements(By.xpath("//button[contains(@class,'tab')]")).size();
    }

    public boolean isTabVisible(String tabName) {
        String xpath = "//button[contains(text(),'" + tabName + "')]";
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public boolean isTabActive(String tabName) {
        String xpath = "//button[contains(text(),'" + tabName + "') and contains(@class,'active')]";
        return driver.findElement(By.xpath(xpath)).isDisplayed();
    }

    public boolean isBackBtnVisible() {
        return driver.findElement(backButton).isDisplayed();
    }


//-------------------------- LOCATORS for Edit Your Profile-Basic  --------------------------

By basicInfoTabBtn = By.xpath("//button[contains(text(),'Basic Information')]");

By basicInfoSectionTitle = By.xpath("//h2[contains(text(),'Basic Information')]");

By basicInfoSubText = By.xpath("//*[contains(text(),'basic personal details') or contains(text(),'Basic info')]");

By nameFieldValue = By.xpath("//input[@name='name' or @id='name']");
By ageFieldValue  = By.xpath("//input[@name='age' or @id='age']");

By nextBodyMetricsBtn = By.xpath("//button[contains(text(),'Next: Body Metrics')]");

private By nameField = By.id("name");   
private By ageField  = By.id("age");    


//  METHODS

public void clickBasicInformationTab() {
    driver.findElement(basicInfoTabBtn).click();
}

public boolean isBasicInfoSectionVisible(String text) {
    return driver.findElement(basicInfoSectionTitle).isDisplayed();
}

public boolean isBasicInfoSubTextVisible(String text) {
    return driver.findElement(basicInfoSubText).isDisplayed();
}

public String getUserName() {
    return driver.findElement(nameFieldValue).getAttribute("value");
}

public String getUserAge() {
    return driver.findElement(ageFieldValue).getAttribute("value");
}

public boolean isNextBodyMetricsEnabled() {
    return driver.findElement(nextBodyMetricsBtn).isEnabled();
}

// basic layout check (name + age vertically aligned)
public boolean areNameAgeFieldsAligned() {
    int nameY = driver.findElement(nameFieldValue).getLocation().getY();
    int ageY  = driver.findElement(ageFieldValue).getLocation().getY();
    return ageY > nameY;  // simply checks vertical alignment
}

   
//-------------------------- LOCATORS for Edit Your Profile-Metrics  --------------------------

By bodyMetricsTabBtn = By.xpath("//button[contains(text(),'Body Metrics')]");
By weightFieldValue  = By.xpath("//input[@name='weight' or @id='weight']");
By heightFieldValue  = By.xpath("//input[@name='height' or @id='height']");

//Optional help text
By heightHint = By.xpath("//*[contains(text(),'decimal')]");

//Unit dropdown
By weightUnitDropdown = By.xpath("//select[@id='weightUnit']");
By heightUnitDropdown = By.xpath("//select[@id='heightUnit']");
private By weightField = By.id("weight");     
private By heightField = By.id("height"); 

private By bmiNumber = By.xpath("//div[contains(@class,'bmi-value')]"); //BMI Number Display

private By bmiSlider = By.xpath("//div[contains(@class,'bmi-slider')]"); //BMI Gradient Slider Bar

private By bmiCategory = By.xpath("//*[contains(text(),'BMI Category') or contains(@class,'bmi-category')]"); //BMI Category text

private By bmiNote = By.xpath("//*[contains(text(),'Note')]"); //BMI Category Note


//METHODS

public void clickBodyMetricsTab() {
    driver.findElement(bodyMetricsTabBtn).click();
}

public String getUserWeight() {
    return driver.findElement(weightFieldValue).getAttribute("value");
}

public String getUserHeight() {
    return driver.findElement(heightFieldValue).getAttribute("value");
}

public boolean isHeightFormatHintVisible() {
    return driver.findElement(heightHint).isDisplayed();
}

public boolean isWeightUnitEnabled() {
    return driver.findElement(weightUnitDropdown).isEnabled();
}

public boolean isHeightUnitEnabled() {
    return driver.findElement(heightUnitDropdown).isEnabled();
}

public boolean areWeightHeightFieldsAligned() {
    int weightY = driver.findElement(weightFieldValue).getLocation().getY();
    int heightY = driver.findElement(heightFieldValue).getLocation().getY();
    return heightY > weightY; // simple vertical alignment check
}


By unitDropdown = By.id("unit");   

public boolean isTextVisible(String text) {
    return driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed();
}
public boolean isUnitVisible(String unit) {
    try {
        WebElement dropdown = driver.findElement(unitDropdown);
        dropdown.click();

        // Find option inside dropdown
        WebElement option = dropdown.findElement(By.xpath(".//option[contains(text(),'" + unit + "')]"));

        return option.isDisplayed() && option.isEnabled();
    } catch (Exception e) {
        return false;
    }
}
public boolean isWeightHeightAligned() {
    try {
        WebElement weight = driver.findElement(weightField);
        WebElement height = driver.findElement(heightField);

        int weightX = weight.getLocation().getX();
        int heightX = height.getLocation().getX();

        boolean aligned = (weightX == heightX);

        return aligned;
    } catch (Exception e) {
        return false;
    }
}
public boolean isBmiNumberVisible() {
    try {
        return driver.findElement(bmiNumber).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isBmiSliderVisible() {
    try {
        return driver.findElement(bmiSlider).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isBmiCategoryVisible() {
    try {
        return driver.findElement(bmiCategory).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isBmiNoteVisible() {
    try {
        return driver.findElement(bmiNote).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isBmiGradientValid() {
    try {
        WebElement slider = driver.findElement(bmiSlider);
        String background = slider.getCssValue("background");

        return background != null &&
               (background.contains("blue") ||
                background.contains("rgb(0,") ) &&   // blue-ish
               background.contains("yellow") &&
               background.contains("orange") &&
               background.contains("red");

    } catch (Exception e) {
        return false;
    }
}
public boolean isButtonVisible(String buttonText) {
    try {
        By dynamicButton = By.xpath("//button[contains(text(),'" + buttonText + "')]");
        return driver.findElement(dynamicButton).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isButtonEnabled(String buttonText) {
    try {
        By dynamicButton = By.xpath("//button[contains(text(),'" + buttonText + "')]");
        return driver.findElement(dynamicButton).isEnabled();
    } catch (Exception e) {
        return false;
    }
}
//---------------------------  Edit Your Profile-Preferences  --------------------------

By preferencesHealthTab = By.xpath("//div[contains(text(),'Preferences & Health')]");

public void clickPreferencesHealthTab() {
    driver.findElement(preferencesHealthTab).click();
}
public boolean isRadioVisible(String label) {
    try {
        By locator = By.xpath("//label[contains(text(),'" + label + "')]/input[@type='radio']");
        return driver.findElement(locator).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public boolean isRadioEnabled(String label) {
    try {
        By locator = By.xpath("//label[contains(text(),'" + label + "')]/input[@type='radio']");
        return driver.findElement(locator).isEnabled();
    } catch (Exception e) {
        return false;
    }
}
public boolean isInfoTextVisible(String text) {
    try {
        By locator = By.xpath("//*[contains(text(),'" + text + "')]");
        return driver.findElement(locator).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}


}
