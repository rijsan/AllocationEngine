package TestCases;


import PageObjects.*;
import org.testng.annotations.Test;

public class HasherTests extends BaseClass
{
    LoginPage login = new LoginPage();
    AllocatePage AllocationOwner =new AllocatePage();
    MyPodsPage ProductOwner = new MyPodsPage();
    Nominations Hasher = new Nominations();
    PodsPlatformPage PO = new PodsPlatformPage();

    @Test
    public void TC01_VerifyHasherLogin() throws InterruptedException {
        login.login_to_website();
        login.go_to_allocation_engine();
    }

    @Test
    public void TC02_VerifyDashboard () throws InterruptedException {
        login.login_to_website();
        login.go_to_allocation_engine();
        Hasher.click_MyNominationsTab().
                verify_dashboard();
    }

    @Test
    public void TC03_VerifyStatusAfterNomination () throws InterruptedException {
        //PO.pod_id = "POD-557";
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();
        Hasher.click_MyNominationsTab().
                Verify_StatusAfterNominating();

    }

    @Test
    public void TC04_Verify_Hasher_AbleTo_confirmNomination() throws InterruptedException {

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_ConfirmNomination();
        Hasher.click_MyNominationsTab()
                .click_yes_confirm_btn()
                .click_Nominated_btn()
                .Confirm_Nomination_disable_check();

    }

    @Test
    public void TC_05_Verify_DisableofConfirmationbtn() throws InterruptedException {

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_ConfirmNomination();
        Hasher.click_MyNominationsTab().
                click_yes_confirm_btn().
                click_Nominated_btn().
                click_Confirm_Nomination_btn().
                click_confirm().
                OptOut_disable_check().
                Confirm_Nomination_disable_check().
                Response_Time_check();

    }

    @Test
    public void TC_06_Verify_StatusafterConfirmation() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_ConfirmNomination();
        Hasher.click_MyNominationsTab().
                click_yes_confirm_btn().
                click_Nominated_btn().
                click_Confirm_Nomination_btn().
                click_confirm().
                click_MyNominationsTab().
                Status_check();

    }
    @Test
    public void TC07_Validate_UpdateMessage_on_Nomination() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .click_Confirm_Nomination_btn()
                .click_confirm()
                .refresh()
                .Validate_Update_Message(prop.getProperty("AOName"));
    }
    @Test
    public void TC08_VerifyConsideredStatus_myNomination() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        //Adding Hasher
        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_Quick_Allocate_Opn()
                .click_Quick_Allocate_Btn()
                .click_Yes_Btn()
                .click_submit_Btn()
                .wait_for_message();

        // Select the HaSher using Quick Allocate
        Hasher
                .click_MyNominationsTab()
                .refresh();
        // Verifying The Considered Status
        ProductOwner
                .Verifying_TheConsideredStatus();


    }
    @Test
    public void TC09_VerifyAllocatedStatus() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        //Adding Hasher
        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_Quick_Allocate_Opn()
                .click_Quick_Allocate_Btn()
                .click_Yes_Btn()
                .click_submit_Btn()
                .wait_for_message()
                .go_back()
                .click_allocation_tab()
                .accept_pod()
                .click_confirm_pod();
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .accept_pod()
                .click_confirm_pod();
        Hasher
                .click_MyNominationsTab()
                .refresh()
                .Verify_allocated_Status();
    }

    @Test
    public void TC10_Verify_Cancelled_Status() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();
        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_Quick_Allocate_Opn()
                .click_Quick_Allocate_Btn()
                .click_Yes_Btn()
                .click_submit_Btn()
                .click_add_hasher()
                .click_Quick_Allocate_Opn1()
                .click_Quick_Allocate_Btn()
                .click_Yes_Btn()
                .click_submit_Btn();
        Hasher
                .Verify_cancelled_status();

    }

    @Test
    public void TC11_Verify_click_on_opt_out_button() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .click_Opt_Out_btn()
                .click_optOutreason_btn()
                .select_optOutOption("Tech Stack Mismatch")
                .click_optOutConfirm_btn()
                .validate_success_msg();

    }
    @Test
    public void TC12_Verify_click_on_confirm_button_without_selecting_reason() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .click_Opt_Out_btn()
                .click_optOutConfirm_btn()
                .validate_error_message();

    }
    @Test
    public void TC13_Verify_choosing_others_option_without_adding_reason() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .click_Opt_Out_btn()
                .click_optOutreason_btn()
                .select_optOutOption("Others")
                .click_optOutConfirm_btn()
                .validate_error_message();

    }
    @Test
    public void TC14_Verify_Opt_out_status() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .click_Opt_Out_btn()
                .click_optOutreason_btn()
                .select_optOutOption("Tech Stack Mismatch")
                .click_optOutConfirm_btn()
                .wait_for_message()
                .go_back()
                .validate_optOut_status();
    }
    @Test
    public void TC15_Verify_disabled_opt_out_button() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .Wait_for_Opt_Out_to_disable()
                .Validate_Update_Message("Allocation Engine");
    }
    @Test
    public void TC16_Verify_Nomination_Role_Disabled() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(prop.getProperty("Email"))
                .nominate_hasher(prop.getProperty("Email"))
                .close_search()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        Hasher.click_MyNominationsTab()
                .click_1st_Nomination()
                .Wait_for_Opt_Out_to_disable()
                .Validate_NominationButton_is_disabled();
    }
}
