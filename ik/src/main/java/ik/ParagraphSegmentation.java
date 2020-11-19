package ik;

import java.util.ArrayList;

public class ParagraphSegmentation {

	public static void main(String[] args) {
		String text = "信息网-立足饲料，服务畜牧 　　问：为什么实行限量供应，买不到限价猪肉怎么办?SH8中国饲料行业信息网-立足饲料，服务畜牧 　　答：临时价格干预期间限价猪肉的供应量是根据我市前期市场需求量平均水平确定的。每个定点摊位供应1头猪，供应量较为充足，市民可以按照日常需求正常购买，完全没有必要盲目“囤货”“抢货”。限价猪肉的投放将对猪肉市场价格产生积极的引导作用，预计短期内猪肉价格不会出现大幅波动，因此消费者即使购买按市场价格销售的猪肉，价格差异也不会太大。SH8中国饲料行业信息网-立足饲料，服务畜牧 　　问：最高限价标准如何确定?SH8中国饲料行业信息网-立足饲料，服务畜牧 　　答：我市每天都会监测淡村、北湖、麻村等多个主要市场的猪肉销售价格，并测算得出前10日的市场均价。各市场最高限价标准根据“低于市场均价10%以上”的原则，考虑各干预品种(精瘦肉、五花肉、后腿肉、排骨)在边猪中所占比重后确定，每10日核定调整一次。SH8中国饲料行业信息网-立足饲料，服务畜牧 　　市场均价和最高限价的价差保持10%以上，主要考虑：一是要让市民切切实实感受到实惠;二是要结合财政的承受能力;三是要与整个猪肉价格走势相适应，限价标准与市场均价不宜差异过大，价格不能大起大落。SH8中国饲料行业信息网-立足饲料，服务畜牧 　　猪肉保卫战打响SH8中国饲料行业信息网-立足饲料，服务畜牧 　　8月21日，国务院常务会议明确，稳定生猪生产和猪肉保供稳价措施，会议指出，稳定生猪生产，保障猪肉供应，事关“三农”发展、群众生活和物价稳定。会议确定：SH8中国饲料行业信息网-立足饲料，服务畜牧 　　一是综合施策恢复生猪生产。加快非洲猪瘟强制扑杀补助发放，采取多种措施加大对生猪调出大县和养殖场(户)的支持，引导有效。";
		for (String PG : GetParagraph(text)) {
			System.out.println(GetSentence(PG));
			for (String S : GetSentence(PG)) {
				System.out.println(S);
			}
		}
	}

	private static ArrayList<String> GetParagraph(String text) {
		ArrayList<String> Paragraph = new ArrayList<String>();
		for (String p : text.replaceAll("\r\n", "\n").split("\n|\t| 　　")) {
			if (p.length() > 0) {
				Paragraph.add(p);
			}
		}
		return Paragraph;
	}

	private static ArrayList<String> GetSentence(String text) {
		ArrayList<String> Sentence = new ArrayList<String>();
		for (String s : text.split("[。|！|!|?|？]")) {
			if (s.length() > 0) {
				Sentence.add(s);
			}
		}
		return Sentence;
	}
}
