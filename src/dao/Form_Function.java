package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Form_Class;

public class Form_Function {

		//①DBアクセスに必要な情報の定数を定義

			//接続先DBのURL(jdbc:mysql://[ホスト名orIPアドレス]:[ポート番号]/[データベース名]?serverTimezone=JST)
			private static final String url = "jdbc:mysql://localhost:3306/company?serverTimezone=JST";
			//ユーザ
			private static final String user = "root";
			//パスワード
			private static final String pw = "Q123";

			//INSERT文を実行するメソッドのサンプル
			//引数は登録したい情報が格納されたBean
			public static void insert(Form_Class s){
				//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql = "INSERT INTO Form(name,mail,Content,file,time) VALUES(?,?,?,?,?)";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					pstmt.setString(1, s.getName());
					pstmt.setString(2, s.getMail());
					pstmt.setString(3, s.getContent());
					pstmt.setString(4, s.getFile());
					pstmt.setString(5, s.getTime());

					//⑧SQLを実行し、DBから結果を受領する
					int result = pstmt.executeUpdate();
					System.out.println(result + "件登録されました。");

					//おまけ：⑥の準備が完了すれば?の値を更新して
					//続けてINSERTすることができる。
					//pstmt.setString(1, "takahashi");
					//pstmt.setInt(2, 20);
					//pstmt.executeUpdate();


				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
			}
			//DELETE文を実行するメソッドのサンプル
			//引数は削除する図書の名前
			public static void delete(String name){
				//②アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;

				try{
					//③JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//④データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//⑤SQL文の元を作成する
					//?をプレースホルダと言います。
					//後の手順で?に値を設定します。
					String sql ="DELETE FROM form WHERE name = ?";

					//⑥SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//⑦プレースホルダに値を設定
					//第1引数→何番目の?に設定するか(1から数える)
					//第2引数→?に設定する値
					if(name == null){
						pstmt.setString(1, null);
					}else{
						pstmt.setString(1, name);
					}


					//⑧SQLを実行し、DBから結果を受領する
					int result = pstmt.executeUpdate();
					System.out.println(result + "件削除されました。");

				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑨DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}

			}

			//全件検索するSELECT文を実行するメソッドのサンプル
			public static ArrayList<Form_Class> selectAll(){
				//アクセスに必要な変数の初期化
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				try{
					//JDBCドライバをロードする
					Class.forName("com.mysql.cj.jdbc.Driver");

					//データベースと接続する(コネクションを取ってくる)
					//第1引数→接続先URL
					//第2引数→ユーザ名
					//第3引数→パスワード
					con = DriverManager.getConnection(url, user, pw);

					//SQL文の元を作成する
					String sql = "SELECT * FROM Form";

					//SQLを実行するための準備(構文解析)
					pstmt = con.prepareStatement(sql);

					//SQLを実行し、DBから結果を受領する
					rs = pstmt.executeQuery();

					//return用のArrayList生成
					ArrayList<Form_Class> list = new ArrayList<Form_Class>();

					//next()の戻り値がfalseになるまでResultSetから
					//データを取得してArrayListに追加していく
					while( rs.next() ){
						String name = rs.getString("name");
						String mail = rs.getString("mail");
						String Content = rs.getString("Content");
						String file = rs.getString("file");
						String time = rs.getString("time");
						Form_Class result = new Form_Class(name, mail,Content,file,time);
						list.add(result);
					}

					//中身の詰まったArrayListを返却する
					return list;

				}  catch (SQLException e){
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("DBアクセスに失敗しました。");
					e.printStackTrace();
				} finally {
					//⑫DBとの切断処理
					try {
						//nullかチェックしないとNullPointerExceptionが
						//発生してしまうためチェックしている。
						if( pstmt != null){
							pstmt.close();
						}
					} catch(SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}

					try {
						if( con != null){
							con.close();
						}
					} catch (SQLException e){
						System.out.println("DB切断時にエラーが発生しました。");
						e.printStackTrace();
					}
				}
				return null;

			}
	}

