from time import sleep
from selenium import webdriver
from selenium.webdriver.common.by import By

driver = webdriver.Chrome()
driver.get("http://localhost/mrbs-1.11.1/")
driver.find_element(By.XPATH, '/html/body/header/nav/nav[1]/nav[2]/form/input[4]').click()
driver.find_element(By.XPATH, '//*[@id="username"]').send_keys("admin")
driver.find_element(By.XPATH, '//*[@id="password"]').send_keys("admin123")
driver.find_element(By.XPATH, '//*[@id="logon"]/fieldset[2]/div/input').click()
# sleep(1)
driver.find_element(By.XPATH, '//*[@id="day_main"]/tbody/tr[1]/td/div/a').click()
driver.find_element(By.XPATH, '//*[@id="view_entry_nav"]/div[1]/div[2]/form/input[5]').click()
driver.find_element(By.XPATH, '//*[@id="description"]').send_keys("test123")
driver.find_element(By.XPATH, '//*[@id="all_day"]').click()
driver.find_element(By.XPATH, '//*[@id="main"]/fieldset[1]/div[9]/div/label[2]/input').click()
driver.find_element(By.XPATH, '//*[@id="rep_type"]/div/div/label[3]/input').click()
driver.find_element(By.XPATH, '//*[@id="main"]/fieldset[4]/div/div/input').click()
# sleep(1)
driver.find_element(By.XPATH, '/html/body/header/nav/nav[1]/nav[2]/form[2]/input[6]').click()
driver.close()
driver.quit()