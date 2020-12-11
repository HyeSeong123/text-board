package textboard.Controller;

import textboard.Container.Container;
import textboard.Service.ExportService;

public class ExportController extends Controller {
	ExportService exportService;

	public ExportController() {
		exportService = Container.exportService;
	}

	public void run(String cmd) {
		if (cmd.equals("export build site")) {
			exportService.makeHtml();
		}
	}
}
