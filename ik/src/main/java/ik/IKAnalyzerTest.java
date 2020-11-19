package ik;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

public class IKAnalyzerTest {
	public static void main(String[] args) throws IOException {
		List<String> Results = new ArrayList<String>();
		List<String> Terms = readtext("../ik/src/main/resources/extend.dic");
		String text = "硫酸根离子的检验:";
		StringReader sr = new StringReader(text);
		IKSegmenter ik = new IKSegmenter(sr, true);// 使用智能分词
		Lexeme lexm = null;
		while ((lexm = ik.next()) != null) {
			if (Terms.contains(lexm.getLexemeText().toString())
					&& Results.contains(lexm.getLexemeText().toString()) == false) {
				Results.add(lexm.getLexemeText());
			}
		}
		System.out.println("测试题目内容为：" + text);
		System.out.println("直接考察的知识元为：" + Results.toString());
	}

	public static List<String> readtext(String path) {
		List<String> terms = new ArrayList<String>();
		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.length() > 0) {
					terms.add(line);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return terms;
	}
}
