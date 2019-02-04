package module.github.api.integration;

import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Tasks {
	Utility utility = new Utility();
	String result = "";
	Scanner s = new Scanner(System.in);
	String token = "";

	public void setToken() {
		System.out.println("Enter User Token:");
		token = s.nextLine();
	}

	public void listAllBranchesOfRepo() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter Repository Name:");
		String repoName = s.nextLine();
		result = utility.makeGetCall("https://github.ncsu.edu/api/v3/repos/" + username + "/" + repoName + "/branches",
				token);
		JSONArray arr = new JSONArray(result);
		System.out.println("List of all  branches for repo:" + repoName + " is as follows");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.getJSONObject(i).getString("name"));
		}
	}

	public void createNewRepo() {
		System.out.println("Enter the new Repo name:(No inter-space)");
		String repoName = s.nextLine();
		System.out.println("Enter the new Repo Description:");
		String repoDescription = s.nextLine();
		JSONObject obj = new JSONObject();
		obj.put("name", repoName);
		obj.put("description", repoDescription);
		obj.put("private", true);
		result = utility.makePostCall("https://github.ncsu.edu/api/v3/user/repos", token, obj);
		JSONObject responseObj = new JSONObject(result);
		System.out.println("Repo created by name:" + responseObj.getString("name") + " with id " + responseObj.getInt("id"));
	}

	public void createNewIssue() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter the Repo name for which you wish to create issue");
		String repoName = s.nextLine();
		System.out.println("Enter Issue Title:");
		String issueTitle = s.nextLine();
		System.out.println("Enter Issue Details:");
		String issueDetails = s.nextLine();
		JSONObject obj = new JSONObject();
		obj.put("title", issueTitle);
		obj.put("body", issueDetails);
		result = utility.makePostCall("https://github.ncsu.edu/api/v3/repos/" + username + "/" + repoName + "/issues",
				token, obj);
		JSONObject responseObj = new JSONObject(result);
		System.out.println("Issue created with title: " + responseObj.getString("title"));
	}

	public void addAssigneeToIssue() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter the Repo name for which you wish to make the change");
		String repoName = s.nextLine();
		System.out.println("Enter Issue number:");
		int issueNumber = s.nextInt();
		s.nextLine();
		System.out.println("Enter Assignees (for multiple, separate with ','(comma))");
		String assignee = s.nextLine();
		JSONObject obj = new JSONObject();
		obj.put("assignees", assignee.split(","));
		result = utility.makePostCall("https://github.ncsu.edu/api/v3/repos/" + username + "/" + repoName + "/issues/"
				+ issueNumber + "/assignees", token, obj);
		JSONObject responseObj = new JSONObject(result);
		System.out.println("Assignees:" + assignee + " added to the issue with title: " + responseObj.getString("title"));
	}

	public void editRepo() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter the Repo name for which you wish to disable issues");
		String repoName = s.nextLine();
		JSONObject obj = new JSONObject();
		obj.put("name", repoName.trim());
		obj.put("has_issues", false);
		result = utility.makePatchCall("https://github.ncsu.edu/api/v3/repos/" + username + "/" + repoName, token, obj);
		JSONObject responseObj = new JSONObject(result);
		System.out.println("Issues Disabled for repo with name " + responseObj.getString("name"));
	}

	public void listReactionsToIssue() {
		System.out.println("Enter Username:");
		String username = s.nextLine();
		System.out.println("Enter the Repo name to which issue belongs:");
		String repoName = s.nextLine();
		System.out.println("Enter Issue number:");
		int issueNumber = s.nextInt();
		s.nextLine();
		result = utility.makeGetCall("https://github.ncsu.edu/api/v3/repos/" + username + "/" + repoName + "/issues/"
				+ issueNumber + "/reactions", token);
		JSONArray arr = new JSONArray(result);
		System.out.println(
				"List of all  reactions for repo:" + repoName + "and issue: " + issueNumber + " is as follows");
		for (int i = 0; i < arr.length(); i++) {
			System.out.println(arr.getJSONObject(i).getString("content"));
		}
	}
}
