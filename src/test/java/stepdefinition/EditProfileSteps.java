/*package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditProfileSteps {

	//---------------------------  Edit Your Profile-UI  --------------------------
@Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
public void user_is_on_the_her_balance_dashboard_with_the_edit_profile_submenu_expanded() {
   
}

@When("User clicks on Edit Profile")
public void user_clicks_on_edit_profile() {
   
}

@Then("{string} title should be visible")
public void title_should_be_visible(String string) {
    
}

@Then("{string} subtitle should be visible")
public void subtitle_should_be_visible(String string) {
  
}

@Then("There should be exactly {int} tabs")
public void there_should_be_exactly_tabs(Integer int1) {

}

@Then("{string} tab should be visible")
public void tab_should_be_visible(String string) {
 
}

@Then("{string} tab should be active by default")
public void tab_should_be_active_by_default(String string) {

}

@Then("Back button should be visible")
public void back_button_should_be_visible() {
    
}

//---------------------------  Edit Your Profile-Basic  --------------------------

@When("User clicks Basic Information tab")
public void user_clicks_basic_information_tab() {
    
}

@Then("{string} should be visible inside section")
public void should_be_visible_inside_section(String string) {
   
}

@Then("{string} sub text should be visible")
public void sub_text_should_be_visible(String string) {
   
}

@Then("Should display the userâ€™s Name as entered during the onboarding process.")
public void should_display_the_user_s_name_as_entered_during_the_onboarding_process() {
   
}

@Then("Should display the userâ€™s Age as entered during the onboarding process.")
public void should_display_the_user_s_age_as_entered_during_the_onboarding_process() {
 
}

@Then("Name and Age fields should be properly aligned vertically with equal spacing")
public void name_and_age_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
   
}

@Then("â€œNext: Body Metricsâ€� button should be visible, enabled")
public void next_body_metrics_button_should_be_visible_enabled() {

}

//---------------------------  Edit Your Profile-Metrics  --------------------------
@When("User clicks Body Metrics Tab")
public void user_clicks_body_metrics_tab() {

}

@Then("{string} should be visible")
public void should_be_visible(String string) {
   
}

@Then("Should display the userâ€™s Weight as entered during the onboarding process.")
public void should_display_the_user_s_weight_as_entered_during_the_onboarding_process() {
   
}

@Then("Should display the userâ€™s Height as entered during the onboarding process.")
public void should_display_the_user_s_height_as_entered_during_the_onboarding_process() {
  
}

@Then("Please enter your height in decimal format \\(e.g., {int}'{double}\"={double}) should be visible")
public void please_enter_your_height_in_decimal_format_e_g_should_be_visible(Integer int1, Double double1, Double double2) {
  
}

@Then("\"kg\"or {string} unit values in dropdown should be visible ,enabled")
public void kg_or_unit_values_in_dropdown_should_be_visible_enabled(String string) {
    
}

@Then("{string} or {string} unit values in dropdown should be visible, enabled")
public void or_unit_values_in_dropdown_should_be_visible_enabled(String string, String string2) {
    
}

@Then("Weight and Height fields should be properly aligned vertically with equal spacing")
public void weight_and_height_fields_should_be_properly_aligned_vertically_with_equal_spacing() {
    
}

@Then("BMI Calculation Number should be displayed with a gradient slider and labels")
public void bmi_calculation_number_should_be_displayed_with_a_gradient_slider_and_labels() {
    
}

@Then("BMI Category section should present with BMI Category")
public void bmi_category_section_should_present_with_bmi_category() {
    
}

@Then("BMI Catogary note should be visible")
public void bmi_catogary_note_should_be_visible() {
    
}

@Then("slider should display a continuous gradient from blue â†’ yellow â†’ orange â†’ red, representing increasing BMI values")
public void slider_should_display_a_continuous_gradient_from_blue_yellow_orange_red_representing_increasing_bmi_values() {
    
}

@Then("{string} Button should be visible ,enabled")
public void button_should_be_visible_enabled(String string) {
    
}

//---------------------------  Edit Your Profile-Preferences  --------------------------


@When("User clicks Preferences & Health Tab")
public void user_clicks_preferences_health_tab() {
    
}

@Then("The following RadioButtons should be visible and enabled:")
public void the_following_radio_buttons_should_be_visible_and_enabled(io.cucumber.datatable.DataTable dataTable) {
    
}

@Then("{string} button should be visible and enabled")
public void button_should_be_visible_and_enabled(String string) {
   
}

@Then("{string} information text should be visible")
public void information_text_should_be_visible(String string) {
  
}

//---------------------------  Edit Your Profile-func  --------------------------


@Given("User is on the Her Balance Dashboard with the Edit Profile submenu expanded")
public void user_is_on_dashboard_edit_profile_expanded() {
    // Implement dashboard state
}

@When("User clicks on Body Metric tab")
public void user_clicks_on_body_metric_tab() {
    // Implement click
}

@Then("User should see Body Metric Section")
public void user_should_see_body_metric_section() {
    // Implement verification
}

@When("User clicks on Preferences & Health tab")
public void user_clicks_on_preferences_and_health_tab() {
    // Implement click
}

@Then("User should see Preferences & Health Section")
public void user_should_see_preferences_and_health_section() {
    // Implement verification
}

@When("User clicks on Next Body Metrics Button")
public void user_clicks_on_next_body_metrics_button() {
    // Implement click
}

@Then("User should see {string} Section")
public void user_should_see_section(String section) {
    // Implement verification
}

@When("User clicks on Next: Preferences Button")
public void user_clicks_on_next_preferences_button() {
    // Implement click
}

@When("User clicks on Back Button on Body Metric section")
public void user_clicks_on_back_button_on_body_metric_section() {
    // Implement click
}

@Then("User should see {string} section")
public void user_should_see_section_lowercase(String section) {
    // Implement verification
}

@When("User clicks on Back Button on Preferences & Health section")
public void user_clicks_on_back_button_on_preferences_and_health_section() {
    // Implement click
}

@When("User clicks on Save Profile on Preferences & Health section after editing values in any field")
public void user_clicks_on_save_profile_after_editing() {
    // Implement click + save
}

@Then("User should see success message {string}")
public void user_should_see_success_message(String message) {
    // Implement verification
}

@When("User clicks on Add Medication Button")
public void user_clicks_on_add_medication_button() {
    // Implement click
}

@Then("User should see {string}")
public void user_should_see_popup_text(String message) {
    // Implement verification
}

//---------------------------  Edit Your Profile Add Medication  --------------------------
  
@Given("User is on the Preferences & Health section")
public void user_is_on_preferences_and_health_section() {
    // Implement navigation check
}

@When("User clicks on Add Medication Button")
public void user_clicks_on_add_medication_button1() {
    // Implement click
}

@Then("Enter Medication name header should be visible")
public void enter_medication_name_header_should_be_visible() {
    // Verify header
}

@Then("Medication name input field should be visible")
public void medication_name_input_field_should_be_visible() {
    // Verify input field
}

@Then("{string} and {string} buttons should be visible")
public void and_buttons_should_be_visible(String ok, String cancel) {
    // Verify both buttons
}

@Then("There should be exactly 2 buttons")
public void there_should_be_exactly_2_buttons() {
    // Verify button count
}

@When("User enters medication name")
public void user_enters_medication_name() {
    // Enter name
}

@When("User clicks on Ok button")
public void user_clicks_on_ok_button() {
    // Click OK
}

@Then("User should see success message {string}")
public void user_should_see_success_message1(String message) {
    // Verify success toast or alert
}

@When("User clicks on Cancel Button without adding medication details")
public void user_clicks_on_cancel_button_without_adding_medication_details() {
    // Click cancel
}

@Then("User should navigate back to Preferences & Health Section page")
public void user_should_navigate_back_to_preferences_and_health_section_page() {
    // Verify return to page
}

}*/
