package gxu.software_engineering.shen10.market.service;

import gxu.software_engineering.shen10.market.entity.User;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public interface UserService {

	/**
	 * 用户注册，必须提供必要的注册信息。
	 * @return 成功注册后的用户。
	 */
	public User register(User user, String confirmedPassword);

	/**
	 * 提供正确的登录信息，返回授权用户。
	 * @return 已经注册但未被冻结的账户。
	 */
	@NotNull(message = "用户名或者密码错误！")
	public User login(@NotBlank String account, @NotBlank String password);

	/**
	 * 查看用户的信息。
	 * @return 给定id的用户。
	 */
	@NotNull(message = "您所查找的用户不存在！")
	public User profile(@Min(1) long id);

	/**
	 * 修改用户信息。
	 * @return 修改成功后的用户。
	 */
	public User modify(@NotNull User user);

	/**
	 * 最新注册的用户列表。
	 * @param count 需要多少条记录。
	 */
	public List<User> latest(@Min(1) @Max(50) int count);

	/**
	 * 查看更多用户。
	 * @param lastUserId 上一个列表项目的用户标识，0表示刷新当前列表。
	 * @param count 需要多少条记录。
	 */
	public List<User> list(@Min(0) long lastUserId, @Min(1) @Max(50) int count);

	/**
	 * 返回所有的卖家数。
	 */
	public long size();

}
