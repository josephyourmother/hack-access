公共的なデータをPDFで公開することに対する情勢について、以下にまとめる。

# 現在までの動き #
  * 三重大学教授 奥村晴彦 さんのブログ Okumura's Blog
    * 2011/3/20
    * データは自動処理可能な形で提供してほしい
    * http://oku.edu.mie-u.ac.jp/~okumura/blog/node/2578
```
今回の大震災に伴う原発事故であちこちで放射線の強度が公開されているが，多くはPDF形式で，数値が取り出しにくく，
ひどいものは印刷してからスキャンした画像PDFである。
いくつか重要なものはExcel/CSV化してとりあえず http://oku.edu.mie-u.ac.jp/~okumura/stat/data/ 
で公開しているが，もともと機械可読（自動処理可能）な形で提供してほしい。
しかも，時間をかけてワープロできれいに罫線を引いて手打ちするのではなく，測定値を実時間で提供
する仕組みを作ってほしい。
なお，このようなデータ提供のセンスも情報リテラシー教育の一つとして学校で教えてほしい。
```

  * 財団法人 地方自治情報センター（LASDEC）
    * 2011/3/22
    * 国民へ発信する重要情報のファイル形式について
    * https://www.lasdec.or.jp/cms/12,22060,84.html
    * サーバー・回線リソースの混雑時の予防措置の観点から、PDFやExcelファイル形式でなく、「HTML形式（テキスト）」「JPEG形式（静止画像データ）」「CSV形式」で発信を『地方自治体』に検討するよう提案。

  * 経済産業省
    * 東北地方太平洋沖地震等に係る情報提供のデータ形式について
    * 2011/3/30
    * http://www.meti.go.jp/policy/mono_info_service/joho/other/2011/0330.html
    * 円滑な情報提供を図る観点から、PDF等自動処理がしにくいデータ形式だけでなく、HTMLやCSV等の自動処理に適したデータ形式を併用してデータ提供する配慮を『日本経済団体連合会の会員各社』に依頼。

  * 経済産業省情報プロジェクト室(@openmeti)
    * 電力アプリについて頂いたご連絡
    * 2011/3/24
    * http://togetter.com/li/115564
    * 東京電力の電力使用状況についてCSV形式でのデータ提供が始まる。それに伴い、経済産業省情報プロジェクト室がマッシュアプリを募集する。

  * 東京電力
    * 福島第一・第二原子力発電所モニタリングによる計測状況
    * 2011/4/12
    * http://www.tepco.co.jp/nu/monitoring/index-j.html
    * モニタリングポストの計測データの提供をPDFだけでなくCSVでも行うようになる。

  * Yahoo! JAPAN広報からのお知らせ
    * 公式避難場所名簿検索を公開
    * 2011/4/28
    * http://blogs.yahoo.co.jp/yj_pr_blog/19741810.html
    * 避難場所名簿の大半がPDFであったため、公開データがうまく活用されていない状況だった。そこで、各地方自治体と連携を取りながら名簿を整理し、DB化を行った。また、総務省に対して、地方自治体に向けて名簿のフォーマットの統一化の働きかけを提案。

  * 情報通信審議会 情報通信政策部会 新事業創出戦略委員会 ICT利活用戦略ワーキンググループ（第4回）会議 【2011/5/18 追加】
    * 2011/4/28
    * http://www.soumu.go.jp/main_sosiki/joho_tsusin/policyreports/joho_tsusin/shinjigyo/02ryutsu02_03000052.html
    * ICT利活用による適切な災害対策情報流通のための課題例 総務省情報流通行政局 情報流通振興課
    * http://www.soumu.go.jp/main_content/000112456.pdf
      * 情報発信側の課題として「発信する情報のデータ形式等に関する配慮」をあげる
```
 アクセス集中による負荷に耐え、携帯電話等のPC以外の端末からでも閲覧できるよう、汎用的で容量の小さいファイル形式を利用
 自動収集、処理が容易となるような共通フォーマットの利用
```
    * Google Person Finder
      * 避難所名簿のPDFがあがっていたことがあって、ボランティア有志の人がOCRをかけて、ボランティアで手分けして入力したことがあった。しかし、Googleと地方自治体が連携するようになって、無駄な作業がなくなった。


# 現在 (2011/5/15) の状況 #
  * 以前より、少しだけ状況は改善している。
  * しかし、現在でも、放射線データに関してはPDFで提供されている公的機関がある。
    * 放射線計測値（METI/経済産業省） http://www.meti.go.jp/earthquake/nuclear/monitor.html
  * また、その上、セキュリティがかかっていて、通常の方法ではデータ抽出ができない場合もある。
    * [Wiki別ページ:セキュリティのかかったPDF](http://code.google.com/p/hack-access/wiki/tool#%E3%82%BB%E3%82%AD%E3%83%A5%E3%83%AA%E3%83%86%E3%82%A3%E3%81%AE%E3%81%8B%E3%81%8B%E3%81%A3%E3%81%9FPDF%E3%81%AB%E3%81%A4%E3%81%84%E3%81%A6)

  * そのため、放射線計測値のPDFのデータを、有志の方がGoogle Spreadsheets化にまとめ直したり、機械可読データに変換してWebサービスやCSVで提供している状況である。
    * radmonitor311 放射線量モニターデータまとめページ http://sites.google.com/site/radmonitor311/

  * 政府の中は、どうなっているかは、以下の座談会内容からうかがい知れる。
    * 4Gamer.net ― 津田大介＆南治一徳＆清水亮らが語る，ゲームとプログラミングの今は昔。ゲームやプログラムはもちろん，大震災にまで話が及んだ座談会を掲載（ミドルウェア/開発ツール）
    * http://www.4gamer.net/games/032/G003263/20110503003/index_3.html
```
津田氏：
で，そんな中でね。政府は「PDFで情報出すようになりました！」とか言ってる。
しかも改ざん防止でテキストのコピペすら不可。
放射線のデータとか，簡単に取り込めて，ビジュアライズして出せるようなサービスを作りたくても作れないんだよね。

清水氏：
CSVで出せと。

津田氏：
いや，実際担当の人と折衝する機会もあったから要望として「CSVでも出した方がいいですよ」って伝えたんですよ。
でも，彼らは「情報の改ざんが怖いから」とかいって応じない。
「元ソースあれば改ざんの心配はある程度防げるでしょう。PDFとCSVで両方出しましょう」と言うと，
担当の人はその意味もわかってるんだけど，デジタルのことがよくわからない“中の人”から
抵抗されるからまずはPDFで，みたいな話になっちゃう。
```