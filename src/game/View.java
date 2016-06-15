package game;

import java.util.List;

import view.ViewListener;
import view.Scene;

public interface View {
        
        void showView();

	void showPresentation();

	void showLobbs(List<Lobb> lobbs);

	void showError(Throwable e);

	void addListener(ViewListener viewListener);

	void startedLobb();

	void paint(Scene scene);

        public String requestName();

}
