package game;

import java.util.List;

import view.ViewListener;

public interface View {
        
        void showView();

	void showPresentation();

	void showLobbs(List<Lobb> lobbs);
        
        Lobb chooseLobb(List<Lobb> lobbs);

	void showError(Throwable e);

	void addListener(ViewListener viewListener);

	void startedLobb();

	void paint(Scene scene);

        public String requestName();

}
