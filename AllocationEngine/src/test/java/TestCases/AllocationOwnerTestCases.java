package TestCases;

import PageObjects.AllocatePage;
import PageObjects.LoginPage;
import PageObjects.MyPodsPage;
import PageObjects.PodsPlatformPage;
import TestCases.BaseClass;
import org.testng.annotations.Test;


public class AllocationOwnerTestCases extends BaseClass
{
    LoginPage login = new LoginPage();
    AllocatePage AllocationOwner =new AllocatePage();
    MyPodsPage ProductOwner = new MyPodsPage();
    PodsPlatformPage PO = new PodsPlatformPage();

    //Saji Tests
    @Test
    public void TC01_verifyLogin() throws InterruptedException
    {
        login.login_to_website();

    }
        @Test
    public void TC02_verifyTitle() throws InterruptedException
    {
        login.login_to_website();
        AllocationOwner.get_title();
    }
    @Test
    public void TC03_verifyVisibilityOfTabs() throws InterruptedException
    {
        login.login_to_website();
        AllocationOwner
                .visible_open_tab()
                .visible_closed_tab()
                .visible_upcoming_tab();
    }
    @Test
    public void TC04_togglingTabMethod() throws InterruptedException
    {
        login.login_to_website();
        AllocationOwner
             .go_to_mynomination()
             .click_allocationsTab();

    }
    @Test
    public void TC05_verifyMostRecentPod() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.Validate_MostRecentPod(PO.pod_id);
    }

    @Test
    public void TC07_VerifyStatusOfPod() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.verify_StatusOfPod();

    }
    @Test
    public void TC08_VerifyStatusOfPodAfterNominate() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn().
                click_add_hasher().
                click_ConfirmNomination().
                click_allocationsTab().
                click_confirm_pod().
                verify_StatusAfterNominate();

    }
    @Test
    public void TC09_VerifyAddingHaSher() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_add_hasher()
                .click_ConfirmNomination();
    }
    @Test
    public void TC10_VerifyFilterOption() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner.click_pod(PO.pod_id).
                click_nominate_btn().
                click_filter().
                click_apply().
                Verify_TheFilter();
    }

    @Test
    public void TC11_check_nomination_count() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();
        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .click_add_hasher()
                .click_ConfirmNomination()
                .wait_for_message()
                .go_back()
                .validate_count(1);
    }

    @Test
    public void TC12_check_count_change() throws InterruptedException
    {
        String hasher1 = "sallyrutherford_test@deloitte.com";
        String hasher2 = "katherinepullman_test@deloitte.com";
        String hasher3 = "evanjames_test@deloitte.com";

        login.login_to_website();
        PO.create_newpod();
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
                .wait_for_consideration()
                .go_back()

                // validate
                .validate_count(3);
    }

    @Test
    public void TC14_check_hasher_allocated() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();

        // AO nominates a hasher
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
                .click_nominate()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .close_feedback();
        // Ao allocates hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_view_response()
                .select_hasher()
                .wait_for_message()
                .click_close()

                // validation
                .validate_selected_hasher();
    }

    @Test
    public void TC15_check_hasher_alrady_allocated() throws InterruptedException
    {
        login.login_to_website();
        PO.create_newpod();

        // AO nominates a hasher
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

        String hasher_nominated = AllocationOwner.name;

        // PO gives confidence level to hasher
        ProductOwner.click_MyPods()
                .click_pod(PO.pod_id)
                .click_nominations()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
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
                .click_confirm_pod();

        // create a new pod
        login.go_to_pods_platform();
        PO.create_newpod();
        login.go_to_allocation_engine();

        // AO nominates a hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .reset_filter()
                .search_hasher(hasher_nominated)
                .nominate_hasher(hasher_nominated)
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
                .close_feedback();

        // Ao allocates hasher
        AllocationOwner.click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_view_response()
                .select_hasher()
                .validate_already_allocated();
    }

    @Test
    public void TC16_nominationPageMethods() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod1();
        //-----Adding Same Hasher in different Roles in the same
      AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .reset_filter()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_ConfirmNomination()
                .go_back()
                .click_confirm_pod()

                .Nominate_Second_Hasher()
                .click_filter()
                .reset_filter()
                .click_apply()
                .search_hasher(prop.getProperty("HasherName"))
                .click_add_hasher()
                .click_ConfirmNomination();

         ProductOwner
                .click_MyPods()
                .click_confirm_pod()
                .click_pod(PO.pod_id)
                .wait_for_consideration()
                .click_nominations()
                 .click_choose_confidence()
                 .provide_ConfidenceLevel()
                .select_hasher()
                .close_feedback()

                .nominate_second_hasher()
                .click_choose_confidence()
                 .provide_ConfidenceLevel()
                .select_hasher()
                .close_feedback();

        AllocationOwner
                .click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_nominate_btn()
                .select_hasher()
                .click_close()
                .Nominate_Second_Hasher()
                .select_hasher()
                .wait_for_message();


    }

    @Test
    public void TC17_VerifyAllocatedHasher() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();

        // Ao Nominates unallocated Hasher
        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .reset_filter()
                .click_apply()
                .change_page_size()
                .nominate_unallocated_hasher()
                .click_ConfirmNomination();

        // PO gives confidence level
        ProductOwner
                .click_MyPods()
                //.click_confirm_pod()
                .click_pod(PO.pod_id)
                .wait_for_consideration()
                .click_nominations()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .close_feedback();

        // AO selects hasher
        AllocationOwner
                .click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_nominate_btn()
                .select_hasher()
                .click_close()
                .get_Allocated_Hasher();


    }

    @Test
    public void TC18_confirmStatusMethods() throws InterruptedException {
        login.login_to_website();
        PO.create_newpod();
        AllocationOwner
                .click_pod(PO.pod_id)
                .click_nominate_btn()
                .click_filter()
                .reset_filter()
                .click_apply()
                .change_page_size()
                .nominate_unallocated_hasher()
                .click_ConfirmNomination();
        ProductOwner
                .click_MyPods()
                //.click_confirm_pod()
                .click_pod(PO.pod_id)
                .wait_for_consideration()
                .click_nominations()
                .click_choose_confidence()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
                .close_feedback();
        AllocationOwner
                .click_allocationsTab()
                .click_pod(PO.pod_id)
                .click_allocation_tab()
                .click_nominate_btn()
                .select_hasher()
                .click_close()
                .accept_pod()
                .click_confirm_pod()
                .click_allocationsTab()
                .get_confirmed_status();



    }

    @Test
    public void TC20_check_closed_status() throws InterruptedException {

        login.login_to_website();
        PO.create_newpod();

        // AO nominates a hasher
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
                .click_nominate()
                .click_choose_confidence()
                .provide_ConfidenceLevel()
                .select_hasher()
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
                .click_confirm_pod();

        // check closed status
         AllocationOwner.click_allocationsTab()
                        .click_closed_tab()
                        .validate_closed_status(PO.pod_id);
    }

    @Test
    public void TC21_verifyStatusAfterSaveConfiguration() throws InterruptedException{
        login.login_to_website();
        PO.create_newpod();

        AllocationOwner.click_UpcomingPods().
                verify_StatusAfterConfigureThePod();
    }
}
