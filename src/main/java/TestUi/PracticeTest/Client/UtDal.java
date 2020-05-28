package TestUi.PracticeTest.Client;

public class UtDal {
    public String test_item;
    public String device;
    public String start_time;
    public String tester;
    public String case_name;
    public String case_owner;
    public StringBuilder failMessage;
    public String fail_info;
    public String end_time;
    public String priority;
    public String result;
    public String title;
    public String build_id;
    public String random_id;
    public UtDal(){}


    public String getCase_owner() {
        return case_owner;
    }

    public UtDal setCase_owner(String case_owner) {
        this.case_owner = case_owner;
        return this;
    }
    
    public String getTest_item() {
        return test_item;
    }

    public UtDal setTest_item(String test_item) {
        this.test_item = test_item;
        return this;
    }

    public String getDevice() {
        return device;
    }

    public UtDal setDevice(String device) {
        this.device = device;
        return this;
    }

    public String getStart_time() {
        return start_time;
    }

    public UtDal setStart_time(String start_time) {
        this.start_time = start_time;
        return this;
    }

    public String getTester() {
        return tester;
    }

    public UtDal setTester(String tester) {
        this.tester = tester;
        return this;
    }

    public String getCase_name() {
        return case_name;
    }

    public UtDal setCase_name(String case_name) {
        this.case_name = case_name;
        return this;
    }

    public StringBuilder getFailMessage() {
        return failMessage;
    }

    public UtDal setFailMessage(StringBuilder failMessage) {
        this.failMessage = failMessage;
        return this;
    }

    public String getFail_info() {
        return fail_info;
    }

    public UtDal setFail_info(String fail_info) {
        this.fail_info = fail_info;
        return this;
    }

    public String getEnd_time() {
        return end_time;
    }

    public UtDal setEnd_time(String end_time) {
        this.end_time = end_time;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public UtDal setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public String getResult() {
        return result;
    }

    public UtDal setResult(String result) {
        this.result = result;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public UtDal setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getBuild_id() {
        return build_id;
    }

    public UtDal setBuild_id(String build_id) {
        this.build_id = build_id;
        return this;
    }

    public String getRandom_id() {
        return random_id;
    }

    public UtDal setRandom_id(String random_id) {
        this.random_id = random_id;
        return this;
    }
}
