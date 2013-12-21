package controle.cci;

import controle.cgt.TabuleiroControle;
import visao.cih.TabuleiroView;
import visao.cih.Window;

public class TabuleiroViewControle {

	private TabuleiroView tabuleiroView = null;
	private TabuleiroControle tabuleiroControle = null;
	private Window window = null;
	
	public TabuleiroViewControle() {
		this.tabuleiroControle = new TabuleiroControle();
		this.criarVisao();
	}
	
	private void criarVisao() {
		this.window = new Window();
		this.tabuleiroView = window.getTabuleiroView();
//		this.tabuleiroView.setValidador(tabuleiroControle);
	}

	public TabuleiroView getTabuleiroView() {
		return tabuleiroView;
	}

	public void setTabuleiroView(TabuleiroView tabuleiroView) {
		this.tabuleiroView = tabuleiroView;
	}

	public TabuleiroControle getTabuleiroControle() {
		return tabuleiroControle;
	}

	public void setTabuleiroControle(TabuleiroControle tabuleiroControle) {
		this.tabuleiroControle = tabuleiroControle;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}
}
