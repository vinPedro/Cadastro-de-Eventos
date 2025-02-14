import com.Events.dao.Persistencia;
import com.Events.model.Adm;
import com.Events.view.JanelaLogin;
import com.Events.view.usuario.JanelaCadastroGerenciador;

public class Programa {

	public static void main(String[] args) throws Exception {

		Adm adm = new Adm();
		try{
			adm = Persistencia.carregar();
		}catch(Exception e){
			adm = new Adm();
			Persistencia.persistir(adm);
		}

		if(adm.getGerenciadores().size() > 0){

			new JanelaLogin();
			
		}else{
			new JanelaCadastroGerenciador();
		}

	}
}
