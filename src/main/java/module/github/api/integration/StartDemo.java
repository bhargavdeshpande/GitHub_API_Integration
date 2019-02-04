package module.github.api.integration;

import java.util.Scanner;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

public class StartDemo {

	public static void main(String[] args) {
		Tasks task = new Tasks();
		task.setToken();
		showOptions(task);
	}

	private static void showOptions(Tasks task) {
		System.out.println("");
		System.out.println("Please choose one option:\n" + "1.List of All branches for a repo\n"
				+ "2.Create a new Repo\n" + "3.Create a new Issue\n" + "4.Add an assignee to an issue\n"
				+ "5.Edit Repo\n" + "6.List the reactions\n" + "7.Exit\n" + "Enter your choice..");
		int choice = 0;
		Scanner s = new Scanner(System.in);
		choice = s.nextInt();
		s.nextLine();
		switch (choice) {
		case 1:
			task.listAllBranchesOfRepo();
			showOptions(task);
			break;
		case 2:
			task.createNewRepo();
			showOptions(task);
			break;
		case 3:
			task.createNewIssue();
			showOptions(task);
			break;
		case 4:
			task.addAssigneeToIssue();
			showOptions(task);
			break;
		case 5:
			task.editRepo();
			showOptions(task);
			break;
		case 6:
			task.listReactionsToIssue();
			showOptions(task);
			break;
		case 7:
			System.out.println("The End of Program");
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}

}
