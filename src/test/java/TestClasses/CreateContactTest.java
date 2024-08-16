package TestClasses;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericUtilities.Base;
import com.vtiger.genericUtilities.WebdriverUtility;
import com.vtiger.genericUtilities.propertyFileUtility;
import com.vtiger.objectrepos.ContactInformationPage;
import com.vtiger.objectrepos.ContactsPage;
import com.vtiger.objectrepos.CreateNewContactPage;
import com.vtiger.objectrepos.HomePage;

public class CreateContactTest extends Base {
	@Test
	public void CreateContact() throws Throwable {
	WebdriverUtility wutil = new WebdriverUtility();
	propertyFileUtility putil = new propertyFileUtility();
	//Click on org module
	HomePage hp = new HomePage(driver);
	hp.clickonContactsLink();
	ContactsPage cp = new ContactsPage(driver);
	cp.clickOnContactLookUpImg();
	CreateNewContactPage cnp = new CreateNewContactPage(driver);
	String fn = putil.readDataFromPf("FNAME");
	String ln = putil.readDataFromPf("LNAME");
	cnp.createNewContact(fn,ln+jutil.getRandomNum() );
	ContactInformationPage ci = new ContactInformationPage(driver);
	String header = ci.getContactHeader();
	SoftAssert s = new SoftAssert();
	s.assertTrue(header.contains("Sharma Harsh Kumar"));
	wutil.getscreenShot(driver);
	Reporter.log("Contact is created successfully and test case is passed");
	}
}
