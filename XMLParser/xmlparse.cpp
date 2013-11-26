#include <string>
#include <iostream>
#include <sstream>
#include <fstream>

/**

Input : 1.txt, 2.txt, 3.txt, ..., i.txt
Format : .swv

Output : 1.xml, 2.xml, 3.xml, ..., i.xml
Format : .xml

*/

int const NUM_OF_FILES = 9;

void dowork(std::string filename) {
	std::ifstream is;
	is.open(filename.c_str());
	std::ofstream os;
	filename.erase(filename.end()-4, filename.end());
	filename += ".xml";
	os.open(filename.c_str());
	
	os << "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n";
	os << "<data>\n";
	int row_count = 0;
	while (!is.eof()) {
		std::string temp_line = "";
		std::getline(is, temp_line);
		if (temp_line[0] != '#' && !temp_line.empty() ) {
			os << "\t<row>\n";
			float num;
			std::stringstream ss;
			ss << temp_line;
			while (ss >> num) {
				os << "\t\t<item>";
				os << num;
				os << "</item>\n";
			}
			os << "\t</row>\n";
			++row_count;
		}
	}
	os << "</data>\n";
	is.close();
	os.close();
}

int main (int argc, char* argv[]) {
	for(int i = 1; i < NUM_OF_FILES+1; ++i) {
		std::stringstream ss;
		ss << i;
		std::string s = "";
		ss >> s;
		s += ".txt";
		dowork(s);
	}
}