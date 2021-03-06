# Exercise 5: Machine Learning

In this exercise you will explore the data and build a simple classifier.

![Exercise architecture](../img/architecture_exercise5.png)

## Setup (Optional)

> **NOTE**: This setup is only required if you don't want to run the architecture using Docker and you prefer to install it yourself. At your own risk. :-)

* Jupyter Notebook install instructions: https://jupyter.org/install
	* If you have Admin rights, install Anacoda framework: https://www.anaconda.com/distribution/
	* If you don't have admin rights install portable python: https://www.python.org/downloads/windows/ and follow installation instructions on https://jupyter.org/install
	* Install several  modules for the notebook:
		* `pip install elasticsearch`
		* `pip install matplotlib`
		* `pip install sklearn`

* Launch Jupyter notebook:
  * Run following on comand line `jupyter notebook`
  * Open it on the browser: http://localhost:8888
  
* If it requires token get it following way:
  * Run on command line --> docker exec docker_jupyter_1 -it bash
  * On docker container get token --> jupyter notebook list
  * Copy token and use it to logon --> http://localhost:8888/?token=c0d7e6262ccb700baa10bb7c51ed26922a79217f04a64faa

## Development

> **NOTE**: If you are using the Docker instance, you will have to run it using the token. Just look at the "jupyter" service logs for the full URL (including the token).

* Load notebook and follow the instructions there.
