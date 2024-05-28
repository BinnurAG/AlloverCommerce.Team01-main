package team01_AlloverCommerceTestNG.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import team01_AlloverCommerceTestNG.utilities.Driver;

public class P1_HomePage {

    public P1_HomePage() {


        PageFactory.initElements(Driver.getDriver(), this);
=======
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[.='Sign In']")
    public WebElement signInButton;


/* Uyguladigimiz adimlar :
A) Intellijeyde yaptigimiz degisiklikleri Github projemize eklemek icin
1. git init (ilk defa olustururken)
2. git branch ayse  (ayse isminde branch olusturma, mutlaka kendimize branch olusturup degisiklikleri bu branch uzerinden gondermeliyiz )
3. git checkout ayse (main branchden kendi branchimize gecis)
4. git branch  (hangi branchde oldugumuzu gosterir)
gelen mesaj:
* ayse
  main   (* ayse branchinde oldugunu gosteriyor)
5. git status (yine hangi branchde oldugumuzu gosteriyor)
gelen mesaj:
On branch ayse
nothing to commit, working tree clean (commit edilen birsey olmadigini ve branchin bos oldugunu soyluyor)
6. Degisikliklerimizi branche eklemek icin
git add .
git commit -m"aysebetul/23/5/24" (seklinde commitmize hem ismimizi hem tarihi yazabiliriz)
7. kendi branchimizi githubtaki projemizin main branchine eklemek icin
git push (yazariz bize " git push --set-upstream origin ayse " seklinde uyari verecektir gelen sekilde yazalim)
8.git push --set-upstream origin ayse
Gelen mesaj:
Bu sekilde bize adres verir uzerine tiklayalim ve githuba ana branch'e merge istegi icin gidelim
remote: Create a pull request for 'ayse' on GitHub by visiting:
remote:      https://github.com/BinnurAG/AlloverCommerce.Team01-main/pull/new/ayse
Bu linke gidince orda
 ayse had recent pushes yazisinin yaninda Compare&pull request kismini gorecegiz oraya tiklayalim
 Eger gozukmediyse yukaridaki pull request kismindan yada
 asagi indigimizde ismimizin yanindaki 3 nokta isaretinden girerek yapabiliriz.
 egerki comment yazmak istiyorsak yazalim
 asagida create pull requeste tiklayalim
 BUNDAN SONRAKI ADIMI GITHUB SORUMLULARINA BIRAKALIM.(merge pull request kismindaki confirm merge kismina tiklamiyoruz)

B) Githubtaki degisiklikleri localimize cekmek icin ise
1. git checkout main  (main branche gecelim)
2. git branch  (hangi branchde oldugumuzu seklinde kontrol edebiliriz)
gelen mesaj:
ayse
*main   (* main branchinde oldugunu gosteriyor)
3. git pull (main branchteki tum yeni hali localimize ceker)
4. git checkout ayse (kendi branchine gec)
5. git merge main ( main branchdekini kendi branchine al)
---baska not: VendorSignIn, ayni yerden giris yapiliyor diye eklenmemis, UserVendorLogInPage
 */

    //--------------for US_09, US_10, ------------------------------------
    @FindBy(partialLinkText = "Sign In")
    public WebElement signInButton;

    @FindBy(xpath = "//a[@href='signup']")
    public WebElement singUpButton;

    @FindBy(xpath = "//div[.='Sign Out']")
    public WebElement signOutButton;

    @FindBy(partialLinkText = "My Account")
    public WebElement myAccountButton;

    @FindBy(xpath = "//span[.='Register']")
    public WebElement registerButton;
}


    @FindBy(xpath = "//a[.='Become a Vendor']")
    public WebElement becomeAVendorButton;
    @FindBy(xpath = "//h2[.='Vendor Registration']")
    public WebElement VendorRegistrationText;
    @FindBy(xpath = "//h3[.='MY ACCOUNT']")
    public WebElement myAccountText;
    @FindBy(xpath = "//span[.='Sign Out']")
    public WebElement signOut;
}