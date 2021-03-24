package puralForm;

import java.util.HashSet;

/**
 * 英単語を複数形にする。
 * */
public class PluralForm {
	FixChain fc = new Uncountable( new MANandCHILD(new Foreign(new Abbribiation(new THESEandTHOSE(new FandFE(new ES(new IES(new Terminal()))))))));
	public PluralForm(){


		print("dog");
		print("cat");
		print("pig");

		print("box");
		print("photo");
		print("axis");
		print("dish");
		print("church");
		print("leaf");
		print("knife");

		print("study");
		print("play");

		print("country");
		print("baby");
		print("knife");
		print("leaf");
		print("man");
		print("child");
		print("woman");
		print("kilo");
		print("photo");
		print("auto");
		print("piano");
		print("concerto");
		print("Eskimo");
		print("soprano");
		print("it");
		print("this");
		print("that");
		print("sugar");
		print("happiness");

	}

	private void print(String s) {
		System.out.print(s+" → ");
		System.out.println(fc.fix(s));
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		new PluralForm();

	}

	private interface FixChain {
		abstract String fix (String tarai);
	}

	/**デザインパターン Chain Of Responsibilityの応用
	 * 再帰関数のような用法*/
	private abstract class Section implements FixChain{
		private FixChain fc;
		public Section(FixChain nextFixChain) {
			this.fc=nextFixChain;
		}
		@Override
		public String fix(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(hasGritch(s)) {
				return fixGritch(s);//うちの診療所で面倒見るわ。
			}else {
				return fc.fix(s);//うちでは分からんからほかの診療所を紹介してあげる。
			}
		}

		public abstract boolean hasGritch(String s);

		public abstract String fixGritch(String s);
	}

	/**終端クラス 必ず最後は終端クラスを取り付けなければならない。
	 *

	 * */
	private class Terminal implements FixChain{
		public Terminal() {
		}

		@Override
		public String fix(String tarai) {
			// TODO 自動生成されたメソッド・スタブ
			return tarai+"s";
		}
	}


	private class Uncountable extends Section{
		/**代表的な不可算名詞なら何も処理しないでリターンする*/
		HashSet<String> hs = new HashSet<String>();
		public Uncountable(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ

			hs.add("water");
			hs.add("air");
			hs.add("sand");
			hs.add("flour");
			hs.add("tea");
			hs.add("coffee");
			hs.add("people");
			hs.add("sugar");
			hs.add("rice");
			hs.add("salt");
			hs.add("bread");
			hs.add("honey");
			hs.add("cheese");
			hs.add("cake");
			hs.add("milk");
			hs.add("beer");
			hs.add("whisky");
			hs.add("whine");
			hs.add("meat");
			hs.add("beef");
			hs.add("pork");
			hs.add("chiken");
			hs.add("ham");
			hs.add("butter");
			hs.add("jam");
			hs.add("margarine");
			hs.add("tofu");
			hs.add("shampoo");
			hs.add("toothpaste");
			hs.add("soap");
			hs.add("cloth");
			hs.add("clothing");
			hs.add("paper");
			hs.add("wood");
			hs.add("furniture");
			hs.add("happiness");
			hs.add("fun");
			hs.add("anger");
			hs.add("information");
			hs.add("music");
			hs.add("literature");
			hs.add("Japan");
			hs.add("Korea");
			hs.add("China");
			hs.add("America");
			hs.add("USA");
			hs.add("Tokyo");
			hs.add("Osaka");
			hs.add("Yokohama");
			hs.add("flour");
			hs.add("chalk");
			hs.add("furniture");
			hs.add("advice");
			hs.add("news");
			hs.add("paper");
			hs.add("socks");
			hs.add("gas");
			hs.add("chocolate");

		}

		@Override
		public boolean hasGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ

			if(hs.contains(s)) {
				return true;
			}else {
				return false;
			}
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			return s;//何も処理しない！！
		}

	}

	private class ES extends Section{

		public ES(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ
		}

		@Override
		public boolean hasGritch(String s) {
			/*
			 * box →boxes
			 * fox →foxes
			 * waltz → waltzes
			 * blitz → blitzes
			 * */
			if(s.endsWith("x") || s.endsWith("z") || s.endsWith("ss") || s.endsWith("sh")||s.endsWith("ch")||s.endsWith("o")|| s.endsWith("s")) {
				return true;
			}

			return false;
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ

			if(s.endsWith("x") || s.endsWith("z") || s.endsWith("ss") || s.endsWith("sh")||s.endsWith("ch")||s.endsWith("o")|| s.endsWith("s")) {
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				sb.append("es");
				return sb.toString();
			}

			return s;
		}

	}

	private class MANandCHILD extends Section{

		public MANandCHILD(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ
		}

		@Override
		public boolean hasGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.endsWith("man")||s.endsWith("child")) {
				return true;
			}
			return false;
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.endsWith("man")) {
				StringBuilder sb = new StringBuilder();
				if(s.equals("man")) {
					return "men";
				}

				sb.append(s.substring(0, s.length()-3));
				sb.append("men");

				return sb.toString();
			}
			if(s.endsWith("child")) {
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				sb.append("ren");
				return sb.toString();
			}
			return s;
		}

	}

	private class IES extends Section{

		public IES(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ
		}

		@Override
		public boolean hasGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.endsWith("y") ) {
				return true;
			}
			return false;
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			//System.out.println("s="+s);
			char[] mozi= new char[5];
			mozi[0]='a';
			mozi[1]='i';
			mozi[2]='u';
			mozi[3]='e';
			mozi[4]='o';
			boolean result =false;
			for(int i=0;i<mozi.length;i++) {
				if(s.charAt(s.length()-2) == mozi[i]) {
					result = true;
					//System.out.println("s="+s+";aiueoと一致");
				}
			}


			if(result == true) {
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, s.length()));
				sb.append("s");
				return sb.toString();
			}



			if(s.endsWith("y")) {
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, s.length()-1));
				sb.append("ies");
				return sb.toString();
			}
			return s;
		}

	}

	private class FandFE extends Section{
		public FandFE(FixChain nextFixChain) {
			super(nextFixChain);
		}

		@Override
		public boolean hasGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			/*knife→knives
			 leaf→leaves
			*/

			if(s.endsWith("fe")||s.endsWith("f")) {
				return true;
			}

			return false;
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			//knife → knives
			if(s.endsWith("fe")) {
				;
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, s.length()-2));
				sb.append("ves");
				return sb.toString();
			}

			if(s.endsWith("f")) {
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, s.length()-1));
				sb.append("ves");
				return sb.toString();
			}



			return s;
		}


	}

	/**外来語の複数形
	 * */
	private class Foreign extends Section {
		public Foreign(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ
		}

		/**うちの診療所の専門の範疇ですか。*/
		public boolean hasGritch(String s) {
			boolean result = false;

			/*
			 * piano→pianos
			 * concerto→concertos
			 * Eskimo→Eskimos
			 * soprano→sopranos
			 *
			 * */

			if(s.equals("piano")) {
				return true;
			}

			if(s.equals("concerto")) {
				return true;
			}

			if(s.equals("Eskimo")) {
				return true;
			}

			if(s.equals("soprano")) {
				return true;
			}


			return result;
		}

		/**うちの専門の範疇ですから、うちの診療所で治療します！！*/
		public String fixGritch(String s) {

			if(s.equals("piano")) {
				return "pianos";
			}

			if(s.equals("concerto")) {
				return "concertos";
			}

			if(s.equals("Eskimo")) {
				return "Eskimos";
			}

			if(s.equals("soprano")) {
				return "sopranos";
			}



			return s;
		}
	}

	/**略語修正*/
	private class Abbribiation extends Section{
		public Abbribiation(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ

		}

	@Override
	public boolean hasGritch(String s){
		boolean result = false;
		// TODO 自動生成されたメソッド・スタブ
		/*
		 * 	kilo→kilos
			photo→ photos
			auto→autos
		 */

		if(s.equals("kilo")) {
			return true;
		}

		if(s.equals("photo")) {
			return true;
		}

		if(s.equals("auto")) {
			return true;
		}

		return false;
	}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.equals("kilo")) {
				return "kilos";
			}

			if(s.equals("photo")) {
				return "photos";
			}

			if(s.equals("auto")) {
				return "autos";
			}

			return s;
		}
	}


	private class THESEandTHOSE extends Section{

		public THESEandTHOSE(FixChain nextFixChain) {
			super(nextFixChain);
			// TODO 自動生成されたコンストラクター・スタブ
		}

		@Override
		public boolean hasGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.equals("this") || s.equals("that")|| s.equals("it")) {
				return true;
			}
			return false;
		}

		@Override
		public String fixGritch(String s) {
			// TODO 自動生成されたメソッド・スタブ
			if(s.equals("this")) {
				return "these";
			}
			if(s.equals("that")) {
				return "those";
			}
			if(s.equals("it")) {
				return "they";
			}

			return s;
		}

	}
	/** 不可算名詞
	 * water air sand flour tea coffee people suger rice salt bread honey cheese cake milk beer whisky
	 * meat beef pork chicken ham butter jam margarine tofu
	 * shampoo toothpaste soap cloth clothing
	 * paper wood furniture
	 * happiness fun anger information music literature life
	 *
	 * 地名
	 * Japan Korea America
	 * Tokyo Hyogo Osaka
	 *
	 * 人名
	 * Trump Jobs Mikitani
	 *
	 *
	 * 液体
	 * a liter of milk
	 * two quarts of whisky
	 * two bottles of water
	 * a glass of water
	 * a cup of tea
	 * a cup of coffee
	 *
	 *
	 * 粉末
	 * 1/4 cups of flour
	 * teaspoonful of salt
	 *
	 * a piece of系
	 * a piece of bread：パン1切れ
	 * a piece of cake：ケーキ1切れ
	 * a piece of chalk : 1本のチョーク
	 * a piece of furniture：1点の家具
	 * a piece of advice：1言の忠告
	 * a piece of news：1本のニュース
	 * a piece of paper：1枚の紙
	 *
	 * a cup of系
	 * a cup of coffee
	 * a cup of water
	 * a cup of beer
	 * a cup of tea
	 *
	 * a grasses of系
	 * a grasses of red whine
	 * a grasses of beer
	 *
	 * a can of 系
	 * a can of beer
	 * a can of tuna
	 *
	 *
	 * a bag of potato chips
	 * a box of cereal
	 * a box of chocolate
	 *
	 * socks → a pair of socks
	 * gas → a gallon of gas
	 *
	 * tea → three cup of tea
	 * honey → three bottle of honey
	 */


}
