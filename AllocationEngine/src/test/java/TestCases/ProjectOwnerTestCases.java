package TestCases;

import PageObjects.*;
import org.testng.annotations.Test;

public class ProjectOwnerTestCases extends BaseClass
{
    LoginPage login = new LoginPage();
    AllocatePage AllocationOwner =new AllocatePage();
    MyPodsPage ProductOwner = new MyPodsPage();
    PodsPlatformPage PO = new PodsPlatformPage();

    @Test
    public void TC01_check_po_able_to_create_newpod() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        // validation
        PO.validate_move_to_allocation();
    }
    @Test
    public void TC03_test_PO_login() throws InterruptedException{
        login.login_to_website();
        login.go_to_allocation_engine();
    }
    @Test
    public void TC04_verifyDashboard() throws InterruptedException {
        login.go_to_allocation_engine();
        login.login_to_website();
        ProductOwner.get_title();
    }
    @Test
    public void TC05_verify_togglingTabMethod() throws InterruptedException {
        login.go_to_allocation_engine();
        login.login_to_website();
        ProductOwner
                .click_MyNominationsTab()
                .click_allocationsTab();

    }
    @Test
    public void TC07_Verify_OpenAndClosedPods_Displayed() throws InterruptedException
    {
        login.login_to_website();
        AllocationOwner.go_to_myPods()
                .visible_open_tab()
                .visible_closed_tab();
    }
    @Test
    public void TC08_VerifyMostRecentPod() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.Validate_MostRecentPod(PO.pod_id);
    }
    // chandana Tests
    @Test
    public void TC09_VerifyStatusOfPod() throws InterruptedException{
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                verify_NewPods();
    }

    @Test
    public void TC10_VerifyMessageBeforeNominating() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        System.out.println(PO.pod_id);
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                click_pod(PO.pod_id).
                Verify_Message();
    }
    @Test
    public void TC11_VerifyStatusAfterNominate() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_add_hasher()
                .click_ConfirmNomination();
        ProductOwner
                .click_MyPods()
                .click_confirm_pod()
                .Verify_StatusAfterNominating();

    }
    @Test
    public void TC13_VerifyConfidenceLevel() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();

        AllocationOwner.click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .click_ResetButton()
                .click_Band()
                .click_apply()
                .click_add_hasher().
                click_ConfirmNomination();
        ProductOwner.click_MyPods()
                .click_confirm_pod()
                .click_pod(PO.pod_id)
                .wait_for_consideration()
                .click_MyPodsNomination()
                .Verifying_TheConsideredStatus()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .Comments()
                .select_hasher();
    }
    @Test
    public void TC14_VerifyStatusResponded() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        ProductOwner.click_MyPods().
                click_pod(PO.pod_id).
                Verify_StatusResponded();


    }

    // saurabh tests
    @Test
    public void TC15_check_nomination_count_update() throws InterruptedException{

        // PO.pod_id="POD-518";
        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .click_add_hasher()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        // po
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .validate_count(1);

    }
    @Test
    public void TC16_check_nominations_count_donot_change() throws InterruptedException{
        // PO.pod_id="POD-528";

        String hasher1 = "sallyrutherford_test@deloitte.com";
        String hasher2 = "katherinepullman_test@deloitte.com";
        String hasher3 = "evanjames_test@deloitte.com";

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates 3 hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()

                .search_hasher(hasher1)
                .nominate_hasher(hasher1)
                .close_search()

                .search_hasher(hasher2)
                .nominate_hasher(hasher2)
                .close_search()

                .search_hasher(hasher3)
                .nominate_hasher(hasher3)

                .click_ConfirmNomination()
                .wait_for_message()
                .go_back();

        // po
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .count_nominations()
                .wait_for_consideration()
                .validate_count(ProductOwner.count);
    }
    @Test
    public void TC18_check_confirmed_status() throws InterruptedException {

        // PO.pod_id = "POD-526";

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        //AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .filter_b8_band()
                .change_page_size()
                .nominate_unallocated_hasher()
                .click_ConfirmNomination()
                .wait_for_message()
                .wait_for_consideration()
                .go_back();

        // PO gives confidence level to hasher
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .click_nominations()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .wait_for_message()
                .close_feedback();

        // Ao allocates hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_view_response()
                .select_hasher()
                .wait_for_message()
                .click_close()
                .accept_pod()
                .click_confirm_pod();

        // validation in mypods
        ProductOwner.click_MyPods()
                .validate_confirmed_status(PO.pod_id);

    }
    @Test
    public void TC19_check_PO_accept_pod() throws InterruptedException {

        //  PO.pod_id = "POD-454";

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        //AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .filter_b8_band()
                .change_page_size()
                .nominate_unallocated_hasher()
                .click_ConfirmNomination()
                .wait_for_message()
                .wait_for_consideration()
                .go_back();

        // PO gives confidence level to hasher
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .click_nominations()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .wait_for_message()
                .close_feedback();

        // Ao allocates hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_view_response()
                .select_hasher()
                .wait_for_message()
                .click_close()
                .accept_pod()
                .click_confirm_pod();

        // po Accepts pod
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .accept_pod()
                .click_confirm_pod()
                .validate_success_msg();
    }
    @Test
    public void TC20_check_closed_status() throws InterruptedException {

        // PO.pod_id = "POD-525";

        login.login_to_website();
        PO.create_newpod();
        login.go_to_allocation_engine();

        //AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .filter_b8_band()
                .change_page_size()
                .nominate_unallocated_hasher()
                .click_ConfirmNomination()
                .wait_for_message()
                .wait_for_consideration()
                .go_back();

        // PO gives confidence level to hasher
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .click_nominations()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .wait_for_message()
                .close_feedback();

        // Ao allocates hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_view_response()
                .select_hasher()
                .wait_for_message()
                .click_close()
                .accept_pod()
                .click_confirm_pod();

        // po Accepts pod
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .accept_pod()
                .click_confirm_pod()
                .wait_for_message()
                .validate_closed_status()
                .go_back()
                .click_closed_tab()
                .validate_closed_status_in_closed_tab(PO.pod_id);
    }
}
