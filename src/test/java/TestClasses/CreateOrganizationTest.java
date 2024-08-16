package TestClasses;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericUtilities.Base;
import com.vtiger.genericUtilities.WebdriverUtility;
import com.vtiger.objectrepos.CreateNewOrganizationPage;
import com.vtiger.objectrepos.HomePage;
import com.vtiger.objectrepos.OrganizationInformationPage;
import com.vtiger.objectrepos.OrganizationPage;

public class CreateOrganizationTest extends Base{
	@Test
	public void createOrg() {
		WebdriverUtility wutil = new WebdriverUtility();
		//Click on org module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		OrganizationPage op = new OrganizationPage(driver);
		//click on OrgLookupImg
		op.clickOnOrgLookUpImg();
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		//Give orgName and save it
		cnop.createNewOrganization("TCS"+jutil.getRandomNum());
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		//Get header of organization
		String header = oip.getHeader();
		SoftAssert s = new SoftAssert();
		s.assertTrue(header.contains("TCS"));
		wutil.getscreenShot(driver);
		Reporter.log("Organization is created successfully and test case is passed");
		
	}
	

}
